package com.ftn.bsep.repository;

import com.ftn.bsep.model.CertificateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateStatusRepository extends JpaRepository<CertificateStatus, Long> {

    CertificateStatus findCertificateStatusByCertificateId(Long certificateId);

}
