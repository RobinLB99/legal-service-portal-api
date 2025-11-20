package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto;

import jakarta.validation.constraints.NotNull;

/**
 * DTO para actualizar el estado de habilitación de un usuario.
 * @param enabled El nuevo estado del usuario (true para habilitado, false para deshabilitado).
 */
public record UsuarioEstadoPatchDTO(
    @NotNull(message = "El campo 'enabled' no puede ser nulo") boolean enabled
) {}
