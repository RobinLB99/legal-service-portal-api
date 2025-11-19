package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Excepción que se lanza cuando no se encuentra una persona natural.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonaNaturalNotFoundException extends RuntimeException {
    /**
     * Construye una nueva PersonaNaturalNotFoundException con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public PersonaNaturalNotFoundException(String message) {
        super(message);
    }
}

