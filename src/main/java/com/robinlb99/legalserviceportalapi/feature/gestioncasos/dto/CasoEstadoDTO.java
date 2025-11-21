package com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para el estado de un caso.
 *
 * @param nuevoEstado El nuevo estado del caso.
 */
public record CasoEstadoDTO(
    @NotBlank(message = "El estado no puede estar nulo o vacío")
    String nuevoEstado
) {}
