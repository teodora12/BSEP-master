package com.ftn.bsep.dto.certificate;

import com.ftn.bsep.security.validation.SQLInjectionSafe;

import java.util.Date;

public class NewCertificateDto {

    private @SQLInjectionSafe String serialNumber;
    private @SQLInjectionSafe String issuerEmail;
    private @SQLInjectionSafe String issuedToCommonName;
    private @SQLInjectionSafe String surname;
    private @SQLInjectionSafe String givenName;
    private @SQLInjectionSafe String organisation;
    private @SQLInjectionSafe String organisationalUnit;
    private @SQLInjectionSafe String country;
    private @SQLInjectionSafe String email;
    private Date validFrom;
    private Date validTo;
    private boolean isCA;
    private @SQLInjectionSafe String keystoreName;
    private @SQLInjectionSafe String keystorePassword;
    private @SQLInjectionSafe String alias;

    public NewCertificateDto() {
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getIssuerEmail() {
        return issuerEmail;
    }

    public void setIssuerEmail(String issuerEmail) {
        this.issuerEmail = issuerEmail;
    }

    public String getIssuedToCommonName() {
        return issuedToCommonName;
    }

    public void setIssuedToCommonName(String issuedToCommonName) {
        this.issuedToCommonName = issuedToCommonName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getOrganisationalUnit() {
        return organisationalUnit;
    }

    public void setOrganisationalUnit(String organisationalUnit) {
        this.organisationalUnit = organisationalUnit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public boolean getIsCA() {
        return isCA;
    }

    public void setCA(boolean isCA) {
        isCA = isCA;
    }

    public String getKeystoreName() {
        return keystoreName;
    }

    public void setKeystoreName(String keystoreName) {
        this.keystoreName = keystoreName;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}
