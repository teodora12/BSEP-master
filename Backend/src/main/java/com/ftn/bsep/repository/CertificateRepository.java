package com.ftn.bsep.repository;

import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    Certificate findCertificateById(Long id);
    List<Certificate> findAllByIsCA(boolean isCA);
    List<Certificate> findCertificatesByUserId(Long userId);
    List<Certificate> findCertificateByIssuedTo(String issuedByEmail);
    List<Certificate> findCertificateByIssuedToAndState(String issuedByEmail, State state);
}
