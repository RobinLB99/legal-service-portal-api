package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

public record DatosClienteNaturalResponseDTO(
        Long id,
        String username,
        String nombres,
        String apellidos,
        String genero,
        String correo_electronico
) {}
