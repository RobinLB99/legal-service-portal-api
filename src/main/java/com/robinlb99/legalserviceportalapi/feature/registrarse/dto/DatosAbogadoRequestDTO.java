package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record DatosAbogadoRequestDTO(
    @NotBlank(message = "Username es obligatorio.")
    String username,

    @NotBlank(message = "La contraseña es requerida.")
    String plainPassword,

    @NotBlank(message = "Nombres son requeridos")
    String nombres,

    @NotBlank(message = "Apellidos son requeridos.")
    String apellidos,

    @Length(min = 10, max = 10, message = "El número de cédula debe contener 10 dígitos")
    @NotBlank(message = "El número de cédula es requerido.")
    String numeroCedula,

    @Email(message = "Debe ingresar un correo electrónico valido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    String correoElectronico,

    @Length(min = 10, max = 15, message = "El número de teléfono debe contener maximo 13 dígitos y mínimo 10 dígitos")
    @NotBlank(message = "Número de teléfono es obligatorio")
    String numeroTelefono,

    @NotBlank(message = "La especialidad es requerida")
    String especialidad,

    @NotBlank(message = "El código de licencia es requerida")
    String licencia
) {}
