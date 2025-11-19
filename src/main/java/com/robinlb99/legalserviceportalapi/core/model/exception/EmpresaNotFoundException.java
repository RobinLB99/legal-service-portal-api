package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Excepción que se lanza cuando no se encuentra una empresa.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpresaNotFoundException extends RuntimeException {
    /**
     * Construye una nueva EmpresaNotFoundException con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public EmpresaNotFoundException(String message) {
        super(message);
    }
}

