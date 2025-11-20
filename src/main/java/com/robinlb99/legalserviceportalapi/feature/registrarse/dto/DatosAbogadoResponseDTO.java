package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

/**
 * DTO para la respuesta de registro de un abogado.
 * @param id ID del abogado registrado.
 * @param username Nombre de usuario del abogado registrado.
 * @param nombres Nombres del abogado registrado.
 * @param apellidos Apellidos del abogado registrado.
 * @param especialidad Especialidad del abogado registrado.
 * @param licencia Licencia del abogado registrado.
 */
public record DatosAbogadoResponseDTO(
    Long id,
    String username,
    String nombres,
    String apellidos,
    String especialidad,
    String licencia
) {}
