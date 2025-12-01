package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto;

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;

public record DocumentoResponseDTO(
    Long id,
    String nombre,
    TipoDocumento tipo,
    Long casoId
) {}
