package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record DatosClienteNaturalRequestDTO(
        @NotBlank(message = "Username es obligatorio.")
        String username,

        @NotBlank(message = "La contraseña es requerida.")
        String plain_password,

        @NotBlank(message = "Nombres son requeridos")
        String nombres,

        @NotBlank(message = "Apellidos son requeridos.")
        String apellidos,

        @NotBlank(message = "El número de cédula es requerido.")
        String numeroCedula,

        @Email(message = "Debe ingresar un correo electrónico valido.")
        @NotBlank(message = "El correo electrónico es obligatorio.")
        String correoElectronico,

        @Max(value = 13, message = "El número de teléfono debe tener un maximo de 12 dígitos")
        @NotBlank(message = "Número de teléfono es obligatorio.")
        String numeroTelefono,

        @NotBlank(message = "La fecha de nacimiento es obligatoria.")
        String fechaNacimiento,

        @NotBlank(message = "El genero es obligatorio.")
        String genero,

        @NotBlank(message = "El estado civil es obligatorio.")
        String estadoCivil,

        @NotBlank(message = "La dirección es obligatoria.")
        String direccionDomicilio
) {}
