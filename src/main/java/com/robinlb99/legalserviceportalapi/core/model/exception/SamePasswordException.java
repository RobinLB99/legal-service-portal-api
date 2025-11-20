package com.robinlb99.legalserviceportalapi.core.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción que se lanza cuando un usuario intenta actualizar su contraseña
 * con la misma contraseña que ya tiene.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SamePasswordException extends RuntimeException {

    /**
     * Construye una nueva SamePasswordException con el mensaje especificado.
     *
     * @param message El mensaje de detalle.
     */
    public SamePasswordException(String message) {
        super(message);
    }
}
