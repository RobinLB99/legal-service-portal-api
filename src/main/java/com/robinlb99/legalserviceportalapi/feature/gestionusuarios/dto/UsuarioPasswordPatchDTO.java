package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para actualizar la contraseña de un usuario.
 * @param plainPassword La nueva contraseña en texto plano.
 */
public record UsuarioPasswordPatchDTO(
    @NotBlank(message = "La contraseña no puede ser nulo o vacía")
    String plainPassword
) {}
