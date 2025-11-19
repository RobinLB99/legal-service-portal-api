package com.robinlb99.legalserviceportalapi.core.model.exception;


/**
 * Excepción que se lanza cuando se proporciona un estado civil no válido.
 */
public class IllegalEstadoCivilException extends RuntimeException {
    /**
     * Construye una nueva IllegalEstadoCivilException con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public IllegalEstadoCivilException(String message) {
        super(message);
    }
}

