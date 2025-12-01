package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DocumentoMapper {

    public Documento toEntity(DocumentoRequestDTO documentoRequestDTO) {
        Documento documento = new Documento();
        documento.setNombre(documentoRequestDTO.nombre().trim());
        documento.setFecha_subida(LocalDateTime.now());
        documento.setMetadatos(documentoRequestDTO.datosAdicionales());
        return documento;
    }

    public DocumentoResponseDTO toDocumentoDTO(Documento documento) {
        return new DocumentoResponseDTO(
            documento.getId(),
            documento.getNombre(),
            documento.getTipo_documento(),
            documento.getCaso().getId()
        );
    }
}
