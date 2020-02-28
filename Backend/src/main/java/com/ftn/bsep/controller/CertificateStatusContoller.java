package com.ftn.bsep.controller;

import com.ftn.bsep.model.CertificateStatus;
import com.ftn.bsep.service.CertificateStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/certificateStatus", produces = MediaType.APPLICATION_JSON_VALUE)
public class CertificateStatusContoller {

    @Autowired
    public CertificateStatusService certificateStatusService;

    @GetMapping(value = "/revoke/{certificateId}")
 //   @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<CertificateStatus> revokeCertificate(@PathVariable Long certificateId)  {

        CertificateStatus certificateStatus = this.certificateStatusService.revokeCertificate(certificateId);

        return new ResponseEntity<>(certificateStatus, HttpStatus.OK);

    }

}
