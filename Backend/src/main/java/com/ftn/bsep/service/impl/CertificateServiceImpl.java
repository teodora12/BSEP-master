package com.ftn.bsep.service.impl;

import com.ftn.bsep.certificate.CertificateGenerator;
import com.ftn.bsep.certificate.keystore.KeyStoreReader;
import com.ftn.bsep.certificate.keystore.KeyStoreWriter;
import com.ftn.bsep.dto.certificate.CertificateDto;
import com.ftn.bsep.dto.certificate.CheckCertificateValidityDto;
import com.ftn.bsep.dto.certificate.NewCertificateDto;
import com.ftn.bsep.exception.CertificateNotInKeystoreException;
import com.ftn.bsep.exception.GenerateKeyPairException;
import com.ftn.bsep.model.*;
import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.repository.CertificateRepository;
import com.ftn.bsep.repository.CertificateStatusRepository;
import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.service.CertificateService;
import com.ftn.bsep.service.CertificateStatusService;
import com.ftn.bsep.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.*;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateStatusService certificateStatusService;

    @Autowired
    private CertificateStatusRepository certificateStatusRepository;

    @Override
    public X509Certificate addCertificate(NewCertificateDto certificateDto) {

        User user = this.userRepository.findUserByEmail(certificateDto.getEmail());
        Long userId = user.getId();
        List<Certificate> userCertificates = this.certificateRepository.findCertificatesByUserId(userId);

        for (Certificate c : userCertificates) {
            if (c.getState().equals(State.valid)) {
                c.setState(State.revoked);
                CertificateStatus certificateStatus = this.certificateStatusService.findCertificateStatusByCertificateId(c.getId());
                if (certificateStatus != null) {
                    certificateStatus.setState(State.revoked);
                    certificateStatusService.saveCertificateStatus(certificateStatus);
                }
                this.certificateRepository.save(c);
            }
        }

        KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(certificateDto.getKeystoreName() + ".jks", certificateDto.getKeystorePassword().toCharArray());

        KeyPair keyPairSubject = generateKeyPair();

        List<Certificate> issuerCertificates = this.certificateRepository.findCertificateByIssuedTo(certificateDto.getIssuerEmail());
        Certificate issuerCertificate = new Certificate();

        for (Certificate c : issuerCertificates) {
            CertificateStatus certificateStatus = this.certificateStatusRepository.findCertificateStatusByCertificateId(c.getId());
            if (certificateStatus.getState().equals(State.valid)) {
                issuerCertificate = c;
                break;
            }
        }

        Certificate certForDatabase = new Certificate(user, Base64.getEncoder().encodeToString(keyPairSubject.getPublic().getEncoded()),
                certificateDto.getValidFrom(), certificateDto.getValidTo(), issuerCertificate.getId(),
                certificateDto.getEmail(), certificateDto.getIssuerEmail(), certificateDto.getIsCA(), certificateDto.getAlias());

        certForDatabase = this.certificateRepository.save(certForDatabase);

        certificateDto.setSerialNumber(certForDatabase.getId().toString());


        KeyStoreReader keyStoreReader = new KeyStoreReader();
        IssuerData issuerData = keyStoreReader.readIssuerFromStore(certificateDto.getKeystoreName(), issuerCertificate.getAlias(),
                certificateDto.getKeystorePassword().toCharArray(), certificateDto.getKeystorePassword().toCharArray());

        SubjectData subjectData = new SubjectData(keyPairSubject, certificateDto, userId);

        CertificateStatus certificateStatus = new CertificateStatus();
        certificateStatus.setCertificateId(certForDatabase.getId());
        certificateStatus.setState(State.valid);
        this.certificateStatusService.saveCertificateStatus(certificateStatus);


        CertificateGenerator certificateGenerator = new CertificateGenerator();
        X509Certificate certificate = certificateGenerator.generateCertificate(subjectData, issuerData);

        keyStoreWriter.write(certificateDto.getAlias(), keyPairSubject.getPrivate(), certificateDto.getKeystorePassword().toCharArray(), certificate);
        keyStoreWriter.saveKeyStore(certificateDto.getKeystoreName() + ".jks", certificateDto.getKeystorePassword().toCharArray());

        log.info("Certificate with alias: "+ certForDatabase.getAlias()+" is generated.");
        return certificate;
    }

    @Override
    public X509Certificate newSelfSignedCertificate(NewCertificateDto certificateDto) {

        User user = this.userRepository.findUserByEmail(certificateDto.getEmail());
        Long userId = user.getId();

        List<Certificate> userCertificates = certificateRepository.findCertificatesByUserId(userId);

        for (Certificate c : userCertificates) {
            if (c.getState() == State.valid) {
                c.setState(State.revoked);
                CertificateStatus certificateStatus = this.certificateStatusService.findCertificateStatusByCertificateId(c.getId());
                certificateStatus.setState(State.revoked);
                certificateStatusService.saveCertificateStatus(certificateStatus);
                this.certificateRepository.save(c);
            }
        }

        KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(certificateDto.getKeystoreName() + ".jks", certificateDto.getKeystorePassword().toCharArray());

        KeyPair keyPairSubject = generateKeyPair();

        Certificate certForDatabase = new Certificate(user, Base64.getEncoder().encodeToString(keyPairSubject.getPublic().getEncoded()),
                certificateDto.getValidFrom(), certificateDto.getValidTo(), 0L, certificateDto.getEmail(),
                certificateDto.getIssuerEmail(), true, certificateDto.getAlias());

        certForDatabase = this.certificateRepository.save(certForDatabase);
        Long idTemp = certForDatabase.getId();
        certForDatabase.setIssuedById(idTemp);
        certForDatabase = this.certificateRepository.save(certForDatabase);     // podesava id issuera na svoj id

        certificateDto.setSerialNumber(certForDatabase.getId().toString());

        CertificateStatus certificateStatus = new CertificateStatus();
        certificateStatus.setCertificateId(certForDatabase.getId());
        certificateStatus.setState(State.valid);
        this.certificateStatusService.saveCertificateStatus(certificateStatus);

        SubjectData subjectData = new SubjectData(keyPairSubject, certificateDto, userId);
        IssuerData issuerData = new IssuerData(keyPairSubject.getPrivate(), certificateDto, userId);

        CertificateGenerator certificateGenerator = new CertificateGenerator();
        X509Certificate certificate = certificateGenerator.generateCertificate(subjectData, issuerData);

        keyStoreWriter.write(certificateDto.getAlias(), keyPairSubject.getPrivate(), certificateDto.getKeystorePassword().toCharArray(), certificate);

        keyStoreWriter.saveKeyStore(certificateDto.getKeystoreName() + ".jks", certificateDto.getKeystorePassword().toCharArray());

        log.info("Self-signed certificate with alias: "+ certForDatabase.getAlias()+" is generated.");
        return certificate;
    }

    @Override
    public List<CertificateDto> getAll() {

        List<Certificate> allCertificates = certificateRepository.findAll();
        Date today = new Date();
        for (Certificate c : allCertificates) {
            if (today.after(c.getExpirationDate())) {
                c.setState(State.expired);
                certificateRepository.save(c);
            }
        }

        List<CertificateDto> certificateDtos = new ArrayList<>();
        for (Certificate c : allCertificates) {
            certificateDtos.add(new CertificateDto(c));
        }
        return certificateDtos;
    }

    @Override
    public CertificateDto findById(Long id) {
        return new CertificateDto(this.certificateRepository.findCertificateById(id));
    }

    @Override
    public List<CertificateDto> findCertificateByUserId(Long userId) {

        List<Certificate> allCertificates = certificateRepository.findCertificatesByUserId(userId);
        List<CertificateDto> certificateDtos = new ArrayList<>();
        for (Certificate c : allCertificates) {
            certificateDtos.add(new CertificateDto(c));
        }
        return certificateDtos;
    }

    @Override
    public boolean checkCertificateValidity(CheckCertificateValidityDto checkCertificateValidityDto) {

        Certificate certificate = this.certificateRepository.findCertificateById(checkCertificateValidityDto.getCertificateId());
        List<Certificate> issuerCertificates = this.certificateRepository.findCertificateByIssuedTo(certificate.getIssuedBy());

        Certificate issuerCertificate = new Certificate();

        boolean valid = false;
        for (Certificate certificate1 : issuerCertificates) {
            CertificateStatus certificateStatus = this.certificateStatusRepository.findCertificateStatusByCertificateId(certificate1.getId());
            if (certificateStatus.getState().equals(State.valid)) {
                issuerCertificate = certificate1;
                valid = true;
                break;
            }
        }
        if (!valid) {
            return false;
        }

        KeyStoreReader keyStoreReader = new KeyStoreReader();

        java.security.cert.Certificate certificateToCheck = keyStoreReader.readCertificate(checkCertificateValidityDto.getKeystoreName(),
                checkCertificateValidityDto.getKeystorePassword(), certificate.getAlias());
        try {
            // verify sa public kljucem issuer-a
            certificateToCheck.verify(loadPublicKey(issuerCertificate.getPublicKey()));

        } catch ( GeneralSecurityException | NullPointerException | IOException e) {
            log.error("Certificate with id: "+checkCertificateValidityDto.getCertificateId()+" doesn't exist in keystore with name: "+ checkCertificateValidityDto.getKeystoreName());
            throw new CertificateNotInKeystoreException(checkCertificateValidityDto.getCertificateId(), checkCertificateValidityDto.getKeystoreName());
        }
        Date today = new Date();

        if (today.after(certificate.getExpirationDate())) {
            certificate.setState(State.expired);
            return false;
        }

        if (certificate.getState().equals(State.revoked)) {
            return false;
        }

        return true;
    }

    private static PublicKey loadPublicKey(String stored) throws GeneralSecurityException, IOException {
        byte[] data = Base64.getDecoder().decode((stored.getBytes()));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);

    }

    private KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(2048, random);
            return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            log.error("Error while generating key pair");
            throw new GenerateKeyPairException();
        }
    }

    @Override
    public CertificateDto save(Certificate certificate) {
        return new CertificateDto(this.certificateRepository.save(certificate));
    }


}
