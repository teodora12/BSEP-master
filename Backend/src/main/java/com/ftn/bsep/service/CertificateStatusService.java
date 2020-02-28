package com.ftn.bsep.service;

import com.ftn.bsep.model.CertificateStatus;
import org.springframework.stereotype.Service;

@Service
public interface CertificateStatusService {

    CertificateStatus saveCertificateStatus(CertificateStatus certificateStatus);
    CertificateStatus revokeCertificate(Long certificateId);
    CertificateStatus findCertificateStatusByCertificateId(Long certificateId);
}
