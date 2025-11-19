package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Excepción que se lanza cuando no se encuentra un usuario.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

    /**
     * Construye una nueva UsuarioNotFoundException con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}

