package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.CertificateStatus;
import com.ftn.bsep.model.State;
import com.ftn.bsep.repository.CertificateRepository;
import com.ftn.bsep.repository.CertificateStatusRepository;
import com.ftn.bsep.service.CertificateService;
import com.ftn.bsep.service.CertificateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateStatusServiceImpl implements CertificateStatusService {

    @Autowired
    private CertificateStatusRepository certificateStatusRepository;

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private CertificateRepository certificateRepository;


    @Override
    public CertificateStatus saveCertificateStatus(CertificateStatus certificateStatus) {
        return certificateStatusRepository.save(certificateStatus);
    }

    @Override
    public CertificateStatus revokeCertificate(Long certificateId) {

        CertificateStatus certificateStatus = certificateStatusRepository.findCertificateStatusByCertificateId(certificateId);
        Certificate certificate = this.certificateRepository.findCertificateById(certificateId);
        certificate.setState(State.revoked);
        this.certificateService.save(certificate);
        certificateStatus.setState(State.revoked);
        certificateStatusRepository.save(certificateStatus);

        return certificateStatus;
    }

    @Override
    public CertificateStatus findCertificateStatusByCertificateId(Long certificateId){
        return certificateStatusRepository.findCertificateStatusByCertificateId(certificateId);


    }


}
