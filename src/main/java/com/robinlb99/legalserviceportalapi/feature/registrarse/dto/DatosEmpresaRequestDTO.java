package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para la solicitud de registro de una empresa.
 * @param username Nombre de usuario para la empresa.
 * @param plainPassword Contraseña en texto plano para la empresa.
 * @param razonSocial Razón social de la empresa.
 * @param ruc RUC de la empresa.
 * @param representanteLegal Representante legal de la empresa.
 * @param correoInstitucional Correo institucional de la empresa.
 * @param telefonoInstitucional Teléfono institucional de la empresa.
 * @param direccionInstitucion Dirección de la institución.
 */
public record DatosEmpresaRequestDTO(
    @NotBlank(
        message = "El Nombre de Usuario es obligatorio y no puede estar vacío."
    )
    String username,

    @NotBlank(message = "La'Contraseña es obligatoria y no puede estar vacío.")
    String plainPassword,

    @NotBlank(
        message = "La Razón Social es obligatorio y no puede estar vacío."
    )
    String razonSocial,

    @NotBlank(message = "El RUC es obligatorio y no puede estar vacío.")
    String ruc,

    @NotBlank(
        message = "El representante legal es obligatorio y no puede estar vacío."
    )
    String representanteLegal,

    @NotBlank(
        message = "El Correo Institucional es obligatorio y no puede estar vacío."
    )
    String correoInstitucional,

    @NotBlank(
        message = "El teléfono Institucional' es obligatorio y no puede estar vacío."
    )
    String telefonoInstitucional,

    @NotBlank(
        message = "La dirección de la institución es obligatoria y no puede estar vacío."
    )
    String direccionInstitucion
) {}
