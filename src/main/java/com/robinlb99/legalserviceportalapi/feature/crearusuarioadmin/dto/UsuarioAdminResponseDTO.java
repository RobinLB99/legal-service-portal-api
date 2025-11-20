package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto;

/**
 * DTO para la respuesta de la creación del usuario administrador.
 *
 * @param id       El ID del usuario administrador.
 * @param username El nombre de usuario del administrador.
 * @param activo   Indica si el usuario administrador está activo.
 */
public record UsuarioAdminResponseDTO(
    Long id,
    String username,
    boolean activo
) {}
