package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

public record DatosAbogadoResponseDTO(
    Long id,
    String username,
    String nombres,
    String apellidos,
    String especialidad,
    String licencia
) {}
