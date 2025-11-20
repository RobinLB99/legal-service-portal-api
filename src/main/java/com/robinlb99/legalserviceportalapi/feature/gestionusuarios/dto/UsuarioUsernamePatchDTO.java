package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para actualizar el nombre de usuario.
 *
 * @param currentUsername El nombre de usuario actual
 * @param newUsername El nuevo nombre de usuario.
 */
public record UsuarioUsernamePatchDTO(
    @NotBlank(message = "El campo 'Current Username' no puede ser nulo o estar vacío")
    String currentUsername,
    @Length(
        min = 8,
        max = 25,
        message = "El nombre de usuario debe tener entre 8 a 25 caracteres"
    )
    @NotBlank(message = "El campo 'New Username' no puede ser nulo o estar vacío")
    String newUsername
) {}
