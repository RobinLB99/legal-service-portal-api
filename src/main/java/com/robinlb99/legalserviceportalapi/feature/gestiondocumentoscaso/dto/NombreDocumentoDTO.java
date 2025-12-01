package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto;

import jakarta.validation.constraints.NotBlank;

public record NombreDocumentoDTO(
    @NotBlank(
        message = "El nombre del documento no puede estar vacío o ser nulo"
    )
    String nombreDocumento
) {}
