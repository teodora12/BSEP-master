package com.ftn.bsep.dto.certificate;

import com.ftn.bsep.dto.user.BasicUserDto;
import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.State;
import com.ftn.bsep.model.User;

import java.util.Date;

/**
 * Certificate with ALL attributes and BasicUserDto(id, name, lastName, email)
 * */
public class CertificateDto {

    private Long id;

    private BasicUserDto user;

    private String alias;

    private Date issuingDate;

    private Date expirationDate;

    private String publicKey;

    private String issuedTo;

    private Long issuedById;

    private String issuedBy;

    private boolean isCA;

    private State state;

    public CertificateDto() {
    }

    public CertificateDto(Certificate certificate) {
        this.id = certificate.getId();
        this.user = new BasicUserDto(certificate.getUser());
        this.alias = certificate.getAlias();
        this.issuingDate = certificate.getIssuingDate();
        this.expirationDate = certificate.getExpirationDate();
        this.publicKey = certificate.getPublicKey();
        this.issuedTo = certificate.getIssuedTo();
        this.issuedById = certificate.getIssuedById();
        this.issuedBy = certificate.getIssuedBy();
        this.isCA = certificate.isCA();
        this.state = certificate.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasicUserDto getUser() {
        return user;
    }

    public void setUser(BasicUserDto user) {
        this.user = user;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(Date issuingDate) {
        this.issuingDate = issuingDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public Long getIssuedById() {
        return issuedById;
    }

    public void setIssuedById(Long issuedById) {
        this.issuedById = issuedById;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public boolean isCA() {
        return isCA;
    }

    public void setCA(boolean CA) {
        isCA = CA;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
