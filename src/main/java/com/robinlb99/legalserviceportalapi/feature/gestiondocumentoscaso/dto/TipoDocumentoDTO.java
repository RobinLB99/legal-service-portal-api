package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto;

import jakarta.validation.constraints.NotBlank;

public record TipoDocumentoDTO(
    @NotBlank(message = "El tipo de documento esta vacío o nulo")
    String tipoDocumento
) {}
