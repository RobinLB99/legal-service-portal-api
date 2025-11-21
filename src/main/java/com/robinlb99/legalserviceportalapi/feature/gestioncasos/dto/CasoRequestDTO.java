package com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para la creación de un caso.
 *
 * @param idAbogado   ID del abogado asignado al caso.
 * @param titulo      Título del caso.
 * @param descripcion Descripción del caso.
 * @param tipoCaso    Tipo de caso.
 */
public record CasoRequestDTO(
    @NotNull(message = "El ID del abogado no puede ser nulo")
    Long idAbogado,
    @NotBlank(message = "El titulo no debe estar vacío o ser nulo")
    String titulo,
    @NotBlank(message = "La descripción no debe estar vacía o ser nula")
    String descripcion,
    @NotBlank(
        message = "Debe especificar un tipo de caso. No debe estar vacío o ser nulo"
    )
    String tipoCaso
) {}
