package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class LoadIssuerFromKeystoreError extends RuntimeException {

    public LoadIssuerFromKeystoreError(String alias, String keystore) {
        super("Error while loading issuer for certificate with alias: "+alias+" from keystore: "+keystore);
    }
}
