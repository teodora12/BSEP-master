package com.microservice.reservation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class UserNotAuthorizedException extends RuntimeException {

    public UserNotAuthorizedException() {
        super("You have to be logged in to make a reservation!");
    }
}

