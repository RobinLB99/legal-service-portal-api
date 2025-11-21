package com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para la descripción de un caso.
 *
 * @param descripcion La nueva descripción del caso.
 */
public record CasoDescripcioDTO(
    @NotBlank(message = "La descripción de caso no puede estar nula o vacía")
    String descripcion
) {}
