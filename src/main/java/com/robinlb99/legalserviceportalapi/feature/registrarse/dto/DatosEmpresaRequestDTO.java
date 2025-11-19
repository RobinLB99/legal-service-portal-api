package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosEmpresaRequestDTO(
        @NotBlank(message = "El Nombre de Usuario es obligatorio y no puede estar vacío.")
        String username,

        @NotBlank(message = "La'Contraseña es obligatoria y no puede estar vacío.")
        String plainPassword,

        @NotBlank(message = "La Razón Social es obligatorio y no puede estar vacío.")
        String razonSocial,

        @NotBlank(message = "El RUC es obligatorio y no puede estar vacío.")
        String ruc,

        @NotBlank(message = "El representante legal es obligatorio y no puede estar vacío.")
        String representanteLegal,

        @NotBlank(message = "El Correo Institucional es obligatorio y no puede estar vacío.")
        String correoInstitucional,

        @NotBlank(message = "El teléfono Institucional' es obligatorio y no puede estar vacío.")
        String telefonoInstitucional,

        @NotBlank(message = "La dirección de la institución es obligatoria y no puede estar vacío.")
        String direccionInstitucion
) {}
