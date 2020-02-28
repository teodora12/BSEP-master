package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ReadPrivateKeyFromKeystoreException extends RuntimeException {

    public ReadPrivateKeyFromKeystoreException(String alias, String keystoreName) {
        super("Error while reading private key for certificate with alias: "+alias+" from keystore with name: "+keystoreName);
    }
}
