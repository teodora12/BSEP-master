package com.ftn.bsep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class KeystoreAccessException extends RuntimeException {

    public KeystoreAccessException() {
        super("Error while accessing keystore");
    }
}
