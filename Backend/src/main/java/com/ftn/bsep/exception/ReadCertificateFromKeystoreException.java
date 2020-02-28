package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ReadCertificateFromKeystoreException extends RuntimeException {

    public ReadCertificateFromKeystoreException(String certificateAlias, String keystoreName) {
        super("Error reading certificate with alias: "+ certificateAlias+" from keystore with name: "+ keystoreName);
    }
}
