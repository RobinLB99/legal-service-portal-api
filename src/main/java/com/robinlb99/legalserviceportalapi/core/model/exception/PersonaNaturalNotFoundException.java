package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonaNaturalNotFoundException extends RuntimeException {
    public PersonaNaturalNotFoundException(String message) {
        super(message);
    }
}
