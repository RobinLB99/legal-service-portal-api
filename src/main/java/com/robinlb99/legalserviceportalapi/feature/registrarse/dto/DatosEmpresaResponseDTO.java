package com.robinlb99.legalserviceportalapi.feature.registrarse.dto;

public record DatosEmpresaResponseDTO(
        Long id,
        String nombreUsuario,
        String razonSocial,
        String representanteLegal
) {}
