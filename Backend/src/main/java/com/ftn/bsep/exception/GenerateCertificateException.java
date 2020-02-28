package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class GenerateCertificateException extends RuntimeException {

    public GenerateCertificateException(String alias) {
        super("Error while generating certificate with alias: "+ alias);
    }
}
