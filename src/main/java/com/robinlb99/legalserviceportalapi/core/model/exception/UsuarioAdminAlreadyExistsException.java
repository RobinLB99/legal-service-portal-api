package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UsuarioAdminAlreadyExistsException extends RuntimeException {
    public UsuarioAdminAlreadyExistsException(String message) {
        super(message);
    }
}
