package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.service.contract;

import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.DocumentoResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto.TipoDocumentoDTO;

/**
 * Interfaz de servicio para la gestión de documentos asociados a casos.
 * Define las operaciones disponibles para adjuntar, obtener, eliminar y modificar
 * documentos de un caso.
 */
public interface IGestionDocumentoCaso {
    /**
     * Adjunta un nuevo documento a un caso existente.
     *
     * @param documentoRequestDTO DTO que contiene los datos del documento a adjuntar.
     * @return Un DTO con la respuesta del documento adjuntado.
     */
    DocumentoResponseDTO adjuntarDocumentoAlCaso(
        Long casoId,
        DocumentoRequestDTO documentoRequestDTO
    );

    /**
     * Obtiene un documento específico por su ID.
     *
     * @param id El ID del documento a obtener.
     * @return Un DTO con la información del documento encontrado.
     */
    DocumentoResponseDTO obtenerDocumentoPorId(Long id);

    /**
     * Elimina un documento de un caso por su ID.
     *
     * @param id El ID del documento a eliminar.
     */
//    void eliminarDocumentoDelCaso(Long id);

    /**
     * Modifica el nombre de un documento específico.
     *
     * @param id El ID del documento a modificar.
     * @param nombreDocumento DTO que contiene el nuevo nombre del documento.
     */
    //    void modificarNombreDocumento(Long id, NombreDocumentoDTO nombreDocumento);

    /**
     * Modifica el tipo de documento de un documento específico.
     *
     * @param id El ID del documento a modificar.
     * @param tipoDocumento DTO que contiene el nuevo tipo de documento.
     */
    void modificarTipoDocumento(Long id, TipoDocumentoDTO tipoDocumento);
}
