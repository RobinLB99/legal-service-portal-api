package com.robinlb99.legalserviceportalapi.feature.gestioncasos.helper;

import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCaso;
import com.robinlb99.legalserviceportalapi.core.model.exception.IllegalEstadoCasoException;
import com.robinlb99.legalserviceportalapi.core.model.exception.IllegalTipoCasoException;
import org.springframework.stereotype.Component;

/**
 * Helper para la gestión de casos.
 */
@Component
public class CasoHelper {

    /**
     * Convierte un string a un enum de EstadoCaso.
     *
     * @param estadoString El estado del caso en string.
     * @return El enum de EstadoCaso.
     * @throws IllegalEstadoCasoException Si el estado del caso no es válido.
     */
    public EstadoCaso obtenerEstadoCaso(String estadoString) {
        return switch (estadoString) {
            case "ACTIVO" -> EstadoCaso.ACTIVO;
            case "REVISION" -> EstadoCaso.REVISION;
            case "CANCELADO" -> EstadoCaso.CANCELADO;
            case "RECHAZADO" -> EstadoCaso.RECHAZADO;
            default -> throw new IllegalEstadoCasoException(
                "Estado de Caso invalido"
            );
        };
    }

    /**
     * Convierte un string a un enum de TipoCaso.
     *
     * @param tipoString El tipo de caso en string.
     * @return El enum de TipoCaso.
     * @throws IllegalTipoCasoException Si el tipo de caso no es válido.
     */
    public TipoCaso obtenerTipoCaso(String tipoString) {
        return switch (tipoString) {
            case "PENAL" -> TipoCaso.PENAL;
            case "CIVIL" -> TipoCaso.CIVIL;
            case "MERCANTIL" -> TipoCaso.MERCANTIL;
            case "LABORAL" -> TipoCaso.LABORAL;
            case "ADMINISTRATIVO" -> TipoCaso.ADMINISTRATIVO;
            case "CONSTITUCIONAL" -> TipoCaso.CONSTITUCIONAL;
            default -> throw new IllegalTipoCasoException(
                "Tipo de caso no valido"
            );
        };
    }
}
