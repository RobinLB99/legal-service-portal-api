package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalTipoDocumentoException extends RuntimeException {

    public IllegalTipoDocumentoException(String message) {
        super(message);
    }
}
