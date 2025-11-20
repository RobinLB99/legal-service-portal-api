package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para actualizar la contraseña de un usuario.
 * @param newPlainPassword La nueva contraseña en texto plano.
 */
public record UsuarioPasswordPatchDTO(

    @NotBlank(message = "El nombre de usuario no puede estar vacío o ser nulo")
    String username,

    @Length(
        min = 8,
        max = 32,
        message = "La contraseña debe tener una longitud entre 8 a 32 caracteres"
    )
    @NotBlank(message = "La contraseña no puede ser nula o vacía")
    String newPlainPassword

) {}
