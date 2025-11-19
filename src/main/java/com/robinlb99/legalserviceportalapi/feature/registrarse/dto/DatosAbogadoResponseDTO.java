package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

/**
 * DTO for the response of registering a lawyer.
 * @param id ID of the registered lawyer.
 * @param username Username of the registered lawyer.
 * @param nombres First names of the registered lawyer.
 * @param apellidos Last names of the registered lawyer.
 * @param especialidad Speciality of the registered lawyer.
 * @param licencia License of the registered lawyer.
 */
public record DatosAbogadoResponseDTO(
    Long id,
    String username,
    String nombres,
    String apellidos,
    String especialidad,
    String licencia
) {}
