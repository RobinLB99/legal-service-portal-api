package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para la creación del usuario administrador.
 * Contiene la contraseña en texto plano.
 *
 * @param username      El nombre de usuario para el administrador.
 * @param plainPassword La contraseña en texto plano para el administrador.
 */
public record UsuarioAdminPasswordDTO(
    @Length(
        min = 8,
        max = 32,
        message = "La contraseña debe tener un longitud de 8 a 32 caracteres"
    )
    String username,
    @NotBlank(message = "La contraseña no puede ser nula o vacía")
    String plainPassword
) {}
