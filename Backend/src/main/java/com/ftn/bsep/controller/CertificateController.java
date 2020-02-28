package com.ftn.bsep.controller;

import com.ftn.bsep.dto.certificate.CertificateDto;
import com.ftn.bsep.dto.certificate.CheckCertificateValidityDto;
import com.ftn.bsep.dto.certificate.NewCertificateDto;
import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.Relation;
import com.ftn.bsep.model.User;
import com.ftn.bsep.service.CertificateService;
import com.ftn.bsep.service.RelationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.cert.X509Certificate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/certificate", produces = MediaType.APPLICATION_JSON_VALUE)
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private RelationService relationService;

    @PostMapping(value = "/new")
    @PreAuthorize("hasAuthority('WRITE_CERTIFICATE')")
    public ResponseEntity generateCertificate(@RequestBody NewCertificateDto certificate)  {

        this.certificateService.addCertificate(certificate);
        return ResponseEntity.ok().build();

    }

    @PostMapping(value = "/self-signed/new")
    @PreAuthorize("hasAuthority('WRITE_CERTIFICATE')")
    public ResponseEntity generateSelfSignedCertificate(@RequestBody NewCertificateDto certificate) {

        this.certificateService.newSelfSignedCertificate(certificate);
        return ResponseEntity.ok().build();

    }
    @RequestMapping(value = "/all")
    @PreAuthorize("hasAuthority('READ_CERTIFICATE')")
    public ResponseEntity<List<CertificateDto>> getAllCertificates (){

        return new ResponseEntity(certificateService.getAll(), HttpStatus.OK);
    }


    @RequestMapping("/httpsAuth")
    public String demo(){
        return "Dozvoljena komunikacij agent-centralna aplikacija";
    }
    @GetMapping(value = "/relations/{id}")
    @PreAuthorize("hasAuthority('READ_CERTIFICATE_RELATIONS')")
    public ResponseEntity<List<User>> getRelationsForCertificateOwner(@PathVariable Long id){

        List<User> relations = this.relationService.allowedRelationsForCertificateOwner(id);

        if(relations == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(relations, HttpStatus.OK);
    }

    @GetMapping(value = "/relations/new/{id}")
    @PreAuthorize("hasAuthority('READ_CERTIFICATE_RELATIONS')")
    public ResponseEntity<List<User>> getNotInRelationWithCertificateOwner(@PathVariable Long id){

        List<User> relations = this.relationService.notInRelationWithCertificateOwner(id);

        if(relations == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity(relations, HttpStatus.OK);
    }

    @PostMapping(value = "/relations/new")
    @PreAuthorize("hasAuthority('WRITE_CERTIFICATE_RELATIONS')")
    public ResponseEntity<Relation> creteNewRelation(@RequestBody Relation relation) {

        relation = this.relationService.newRelation(relation);

        return new ResponseEntity<>(relation, HttpStatus.OK);
    }

    @PostMapping(value = "/relations")
    @PreAuthorize("hasAuthority('WRITE_CERTIFICATE_RELATIONS')")
    public ResponseEntity deleteRelation(@RequestBody Relation relation) {
        boolean success = this.relationService.deleteRelation(relation);

        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/validity")
    @PreAuthorize("hasAuthority('READ_CERTIFICATE')")
    public ResponseEntity checkCertificateValidity(@RequestBody CheckCertificateValidityDto checkCertificateValidityDto){

        boolean valid = this.certificateService.checkCertificateValidity(checkCertificateValidityDto);

        if (valid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
