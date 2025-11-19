package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * DTO para la solicitud de registro de una persona natural.
 * @param username Nombre de usuario para la persona natural.
 * @param plain_password Contraseña en texto plano para la persona natural.
 * @param nombres Nombres de la persona natural.
 * @param apellidos Apellidos de la persona natural.
 * @param numeroCedula Número de cédula de la persona natural.
 * @param correoElectronico Correo electrónico de la persona natural.
 * @param numeroTelefono Número de teléfono de la persona natural.
 * @param fechaNacimiento Fecha de nacimiento de la persona natural.
 * @param genero Género de la persona natural.
 * @param estadoCivil Estado civil de la persona natural.
 * @param direccionDomicilio Dirección de domicilio de la persona natural.
 */
public record DatosPersonaNaturalRequestDTO(
    @NotBlank(message = "Username es obligatorio.") String username,

    @NotBlank(message = "La contraseña es requerida.") String plain_password,

    @NotBlank(message = "Nombres son requeridos") String nombres,

    @NotBlank(message = "Apellidos son requeridos.") String apellidos,

    @NotBlank(message = "El número de cédula es requerido.")
    String numeroCedula,

    @Email(message = "Debe ingresar un correo electrónico valido.")
    @NotBlank(message = "El correo electrónico es obligatorio.")
    String correoElectronico,

    @Length(
        min = 10,
        max = 13,
        message = "El numero de teléfono debe ser 10 dígitos mínimos y 12 dígitos máximos"
    )
    @NotBlank(message = "Número de teléfono es obligatorio")
    String numeroTelefono,

    @NotBlank(message = "La fecha de nacimiento es obligatoria")
    String fechaNacimiento,

    @NotBlank(message = "El genero es obligatorio.")
    String genero,

    @NotBlank(message = "El estado civil es obligatorio.")
    String estadoCivil,

    @NotBlank(message = "La dirección es obligatoria.")
    String direccionDomicilio
) {}
