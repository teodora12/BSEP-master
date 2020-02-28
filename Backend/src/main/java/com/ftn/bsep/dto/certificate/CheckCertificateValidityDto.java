package com.ftn.bsep.dto.certificate;

import com.ftn.bsep.security.validation.SQLInjectionSafe;

public class CheckCertificateValidityDto {


    private @SQLInjectionSafe String keystoreName;
    private @SQLInjectionSafe String keystorePassword;
    private @SQLInjectionSafe Long certificateId;


    public CheckCertificateValidityDto() {
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

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }
}
