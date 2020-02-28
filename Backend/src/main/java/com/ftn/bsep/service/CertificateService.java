package com.ftn.bsep.service;

import com.ftn.bsep.dto.certificate.CertificateDto;
import com.ftn.bsep.dto.certificate.CheckCertificateValidityDto;
import com.ftn.bsep.dto.certificate.NewCertificateDto;
import com.ftn.bsep.dto.keystore.NewKeystoreDto;
import com.ftn.bsep.model.Certificate;
import org.springframework.stereotype.Service;

import java.security.cert.X509Certificate;
import java.util.List;

@Service
public interface CertificateService {

    X509Certificate addCertificate(NewCertificateDto certificate);
    X509Certificate newSelfSignedCertificate(NewCertificateDto certificate);
     List<CertificateDto> getAll();
     CertificateDto findById(Long id);
    CertificateDto save(Certificate certificate);
    List<CertificateDto> findCertificateByUserId(Long userId);
    boolean checkCertificateValidity(CheckCertificateValidityDto checkCertificateValidityDto);
}
