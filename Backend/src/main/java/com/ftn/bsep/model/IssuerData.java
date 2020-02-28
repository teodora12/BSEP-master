package com.ftn.bsep.model;

import com.ftn.bsep.dto.certificate.NewCertificateDto;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

import java.security.PrivateKey;

public class IssuerData {

    private Long id;
    private String x500nameString;
    private X500Name x500name;
    private PrivateKey privateKey;

    public IssuerData() {
    }

    public IssuerData(PrivateKey privateKey, X500Name x500Name) {
        this.privateKey = privateKey;
        this.x500name = x500Name;
    }
    public IssuerData(PrivateKey privateKey, NewCertificateDto certificateDto, Long issuerId) {
        this.privateKey = privateKey;
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
        builder.addRDN(BCStyle.CN, certificateDto.getIssuedToCommonName());
        builder.addRDN(BCStyle.SURNAME, certificateDto.getSurname());
        builder.addRDN(BCStyle.GIVENNAME, certificateDto.getGivenName());
        builder.addRDN(BCStyle.O, certificateDto.getOrganisation());
        builder.addRDN(BCStyle.OU, certificateDto.getOrganisationalUnit());
        builder.addRDN(BCStyle.C, certificateDto.getCountry());
        builder.addRDN(BCStyle.E, certificateDto.getEmail());

        //UID (USER ID) je ID korisnika
        //     builder.addRDN(BCStyle.UID, "123456");
        builder.addRDN(BCStyle.UID, issuerId.toString());
        builder.addRDN(BCStyle.SERIALNUMBER, certificateDto.getSerialNumber());

        this.x500name = builder.build();
    }

    public String getX500nameString() {
        return x500nameString;
    }

    public void setX500nameString(String x500nameString) {
        this.x500nameString = x500nameString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public X500Name getX500name() {
        return x500name;
    }

    public void setX500name(X500Name x500name) {
        this.x500name = x500name;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }


}
