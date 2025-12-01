package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import com.robinlb99.legalserviceportalapi.core.model.exception.DocumentoNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.DocumentoRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IDocumentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentoServiceImpl implements IDocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoServiceImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    @Transactional
    public Documento adjuntarDocumentoAlCaso(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    @Transactional
    public void eliminarRegistroDocumento(Long id) {
        documentoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void actualizarNombreDocumento(Long id, String nombreDocumento) {
        documentoRepository.updateDocumentName(id, nombreDocumento);
    }

    @Override
    @Transactional
    public void actualizarTipoDocumento(Long id, TipoDocumento tipoDocumento) {
        documentoRepository.updateTypeDocumento(id, tipoDocumento);
    }

    @Override
    @Transactional(readOnly = true)
    public Documento obtenerDocumentoPorId(Long id) {
        return documentoRepository
            .findById(id)
            .orElseThrow(() ->
                new DocumentoNotFoundException(
                    "El documento con el id " + id + " no existe"
                )
            );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Documento> obtenerTodosDocumentosPaginados(int page, int size) {
        Pageable pageable = PageRequest.of(
            page,
            size,
            Sort.by("id").ascending()
        );
        return documentoRepository.findAll(pageable);
    }

    @Override
    public void guardarArchivoEnServidor(
        String uri,
        String nombreDocumento,
        MultipartFile file
    ) {}

    @Override
    public void eliminarArchivoEnServidor(String uri, String nombreDocumento) {}

    @Override
    public void actualizarNombreArchivoEnServidor(
        Long id,
        String uri,
        String nombreDocumento
    ) {}
}
