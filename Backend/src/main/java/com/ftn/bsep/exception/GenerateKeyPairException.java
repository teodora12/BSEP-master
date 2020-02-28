package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class GenerateKeyPairException extends RuntimeException {

    public GenerateKeyPairException() {
        super("Error while generating key pair");
    }
}
