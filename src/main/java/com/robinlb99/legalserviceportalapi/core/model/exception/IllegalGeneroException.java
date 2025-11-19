package com.robinlb99.legalserviceportalapi.core.model.exception;


/**
 * Excepción que se lanza cuando se proporciona un género no válido.
 */
public class IllegalGeneroException extends RuntimeException {
    /**
     * Construye una nueva IllegalGeneroException con el mensaje de detalle especificado.
     *
     * @param message El mensaje de detalle.
     */
    public IllegalGeneroException(String message) {
        super(message);
    }
}

