package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CertificateNotInKeystoreException extends RuntimeException {


    public CertificateNotInKeystoreException(final Long certificateId, final String keystoreName) {
        super("Certificate with id: "+certificateId+" doesn't exist in keystore with name: "+ keystoreName);
    }
}
