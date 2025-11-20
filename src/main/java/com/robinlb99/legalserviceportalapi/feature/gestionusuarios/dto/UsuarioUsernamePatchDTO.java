package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para actualizar el nombre de usuario.
 * @param username El nuevo nombre de usuario.
 */
public record UsuarioUsernamePatchDTO(
    @Length(
        min = 8,
        max = 25,
        message = "El nombre de usuario debe tener entre 8 a 25 caracteres"
    )
    @NotBlank(message = "El campo 'Username' no puede ser nulo o estar vacío")
    String username
) {}
