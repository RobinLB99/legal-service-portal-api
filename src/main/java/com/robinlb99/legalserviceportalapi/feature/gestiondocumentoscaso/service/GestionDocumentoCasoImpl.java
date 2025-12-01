package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import com.robinlb99.legalserviceportalapi.core.service.CasoServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.DocumentoServiceImpl;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.TipoDocumentoDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.helper.DocumentoHelper;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.mapper.DocumentoMapper;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.service.contract.IGestionDocumentoCaso;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GestionDocumentoCasoImpl implements IGestionDocumentoCaso {

    private final DocumentoServiceImpl documentoService;
    private final CasoServiceImpl casoService;
    private final DocumentoHelper documentoHelper;
    private final DocumentoMapper documentoMapper;

    public GestionDocumentoCasoImpl(
        DocumentoServiceImpl documentoService,
        CasoServiceImpl casoService,
        DocumentoHelper documentoHelper,
        DocumentoMapper documentoMapper
    ) {
        this.documentoService = documentoService;
        this.casoService = casoService;
        this.documentoHelper = documentoHelper;
        this.documentoMapper = documentoMapper;
    }

    @Override
    @Transactional
    public DocumentoResponseDTO adjuntarDocumentoAlCaso(
        Long casoId,
        DocumentoRequestDTO documentoRequestDTO
    ) {
        Caso caso = casoService.obtenerCasoPorId(casoId);
        TipoDocumento tipoDocumento = documentoHelper.obtenerTipoDocumento(
            documentoRequestDTO.tipoDocumento()
        );

        Documento documento = documentoMapper.toEntity(documentoRequestDTO);
        documento.setCaso(caso);
        documento.setTipo_documento(tipoDocumento);
        documento.setUrl_archivo(
            "/data/documentos/" +
                casoId +
                "/" +
                documentoRequestDTO
                    .nombre()
                    .trim()
                    .toLowerCase()
                    .replace(" ", "_") +
                ".pdf"
        );

        documento = documentoService.adjuntarDocumentoAlCaso(documento);
        return documentoMapper.toDocumentoDTO(documento);
    }

    @Override
    @Transactional(readOnly = true)
    public DocumentoResponseDTO obtenerDocumentoPorId(Long id) {
        Documento documento = documentoService.obtenerDocumentoPorId(id);
        return documentoMapper.toDocumentoDTO(documento);
    }

    //    @Override
    //    @Transactional
    //    public void eliminarDocumentoDelCaso(Long id) {
    //
    //    }

    @Override
    @Transactional
    public void modificarTipoDocumento(
        Long id,
        TipoDocumentoDTO tipoDocumentoDTO
    ) {
        TipoDocumento tipoDocumento = documentoHelper.obtenerTipoDocumento(
            tipoDocumentoDTO.tipoDocumento()
        );

        documentoService.actualizarTipoDocumento(id, tipoDocumento);
    }
}
