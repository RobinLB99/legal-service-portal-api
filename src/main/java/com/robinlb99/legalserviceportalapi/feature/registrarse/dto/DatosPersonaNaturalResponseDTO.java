package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

/**
 * DTO para la respuesta del registro de una persona natural.
 * @param id ID de la persona natural registrada.
 * @param username Nombre de usuario de la persona natural registrada.
 * @param nombres Nombres de la persona natural registrada.
 * @param apellidos Apellidos de la persona natural registrada.
 * @param genero Género de la persona natural registrada.
 * @param correo_electronico Correo electrónico de la persona natural registrada.
 */
public record DatosPersonaNaturalResponseDTO(
    Long id,
    String username,
    String nombres,
    String apellidos,
    String genero,
    String correo_electronico
) {}
