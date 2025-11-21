package com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto;

import java.time.LocalDate;

/**
 * DTO para la respuesta de un caso.
 *
 * @param casoId             ID del caso.
 * @param titulo             Título del caso.
 * @param descripcion        Descripción del caso.
 * @param tipoCaso           Tipo de caso.
 * @param fechaCreacion      Fecha de creación del caso.
 * @param fechaActualizacion Fecha de actualización del caso.
 * @param fechaCierre        Fecha de cierre del caso.
 * @param abogadoId          ID del abogado asignado al caso.
 * @param clienteId          ID del cliente del caso.
 */
public record CasoResponseDTO(
    Long casoId,
    String titulo,
    String descripcion,
    String tipoCaso,
    LocalDate fechaCreacion,
    LocalDate fechaActualizacion,
    LocalDate fechaCierre,
    Long abogadoId,
    Long clienteId
) {}
