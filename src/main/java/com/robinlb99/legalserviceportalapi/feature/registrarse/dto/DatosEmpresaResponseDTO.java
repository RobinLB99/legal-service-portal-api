package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

/**
 * DTO para la respuesta del registro de una empresa.
 * @param id ID de la empresa registrada.
 * @param nombreUsuario Nombre de usuario de la empresa registrada.
 * @param razonSocial Razón social de la empresa registrada.
 * @param representanteLegal Representante legal de la empresa registrada.
 */
public record DatosEmpresaResponseDTO(
    Long id,
    String nombreUsuario,
    String razonSocial,
    String representanteLegal
) {}
