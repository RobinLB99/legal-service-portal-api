package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalTipoCasoException extends RuntimeException {
    public IllegalTipoCasoException(String message) {
        super(message);
    }
}
