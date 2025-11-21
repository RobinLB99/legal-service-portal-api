package com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para el título de un caso.
 *
 * @param titulo El nuevo título del caso.
 */
public record CasoTituloDTO(
    @NotBlank(message = "El titulo del caso no puede estar vacío o nulo")
    String titulo
) {}
