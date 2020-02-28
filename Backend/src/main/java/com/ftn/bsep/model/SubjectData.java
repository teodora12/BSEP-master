package com.ftn.bsep.model;

import com.ftn.bsep.dto.certificate.NewCertificateDto;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

import javax.persistence.*;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Date;

public class SubjectData {

    private Long id;

    private PublicKey publicKey;
    private String x500nameString;
    private X500Name x500name;
    private String serialNumber;
    private Date startDate;
    private Date endDate;

    public SubjectData() {
    }

    public SubjectData(KeyPair keyPair, NewCertificateDto certificateDto, Long userId) {
        this.publicKey = keyPair.getPublic();

        //klasa X500NameBuilder pravi X500Name objekat koji predstavlja podatke o vlasniku
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
        builder.addRDN(BCStyle.CN, certificateDto.getIssuedToCommonName());
        builder.addRDN(BCStyle.SURNAME, certificateDto.getSurname());
        builder.addRDN(BCStyle.GIVENNAME, certificateDto.getGivenName());
        builder.addRDN(BCStyle.O, certificateDto.getOrganisation());
        builder.addRDN(BCStyle.OU, certificateDto.getOrganisationalUnit());
        builder.addRDN(BCStyle.C, certificateDto.getCountry());
        builder.addRDN(BCStyle.E, certificateDto.getEmail());
        //UID (USER ID) je ID korisnika
    //    builder.addRDN(BCStyle.UID, "123456");

        builder.addRDN(BCStyle.UID, userId.toString());
        builder.addRDN(BCStyle.SERIALNUMBER, certificateDto.getSerialNumber());
        this.x500name = builder.build();
        this.serialNumber = "1";

        this.startDate = certificateDto.getValidFrom();
        this.endDate = certificateDto.getValidTo();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public X500Name getX500name() {
        return x500name;
    }

    public void setX500name(X500Name x500name) {
        this.x500name = x500name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getX500nameString() {
        return x500nameString;
    }

    public void setX500nameString(String x500nameString) {
        this.x500nameString = x500nameString;
    }
}
