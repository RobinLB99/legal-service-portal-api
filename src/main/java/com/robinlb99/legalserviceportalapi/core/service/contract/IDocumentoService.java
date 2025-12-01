package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interfaz de servicio para la gestión de documentos.
 * Define las operaciones relacionadas con documentos, incluyendo adjuntar, eliminar,
 * guardar y actualizar información de documentos tanto en la base de datos como en el servidor.
 */
public interface IDocumentoService {
    /**
     * Adjunta un documento a un caso.
     *
     * @param documento El objeto Documento a adjuntar.
     * @return El Documento adjuntado.
     */
    Documento adjuntarDocumentoAlCaso(Documento documento);

    /**
     * Elimina un registro de documento de la base de datos por su ID.
     *
     * @param id El ID del documento a eliminar.
     */
    void eliminarRegistroDocumento(Long id);

    /**
     * Guarda un archivo MultipartFile en el servidor.
     *
     * @param uri             La URI donde se guardará el archivo.
     * @param nombreDocumento El nombre que tendrá el archivo.
     * @param file            El archivo MultipartFile a guardar.
     */
    void guardarArchivoEnServidor(
        String uri,
        String nombreDocumento,
        MultipartFile file
    );

    /**
     * Elimina un archivo del servidor.
     *
     * @param uri             La URI donde se encuentra el archivo.
     * @param nombreDocumento El nombre del archivo a eliminar.
     */
    void eliminarArchivoEnServidor(String uri, String nombreDocumento);

    /**
     * Actualiza el nombre de un documento en la base de datos.
     *
     * @param id              El ID del documento a actualizar.
     * @param nombreDocumento El nuevo nombre del documento.
     */
    void actualizarNombreDocumento(Long id, String nombreDocumento);

    /**
     * Actualiza el nombre de un archivo en el servidor.
     *
     * @param id              El ID del documento asociado.
     * @param uri             La URI donde se encuentra el archivo.
     * @param nombreDocumento El nuevo nombre del archivo.
     */
    void actualizarNombreArchivoEnServidor(
        Long id,
        String uri,
        String nombreDocumento
    );

    /**
     * Actualiza el tipo de documento en la base de datos.
     *
     * @param id            El ID del documento a actualizar.
     * @param tipoDocumento El nuevo tipo de documento.
     */
    void actualizarTipoDocumento(Long id, TipoDocumento tipoDocumento);

    /**
     * Obtiene un documento por su ID.
     * @param id El ID del documento a obtener.
     * @return El documento encontrado.
     */
    Documento obtenerDocumentoPorId(Long id);

    /**
     * Obtiene todos los documentos paginados.
     * @param page El número de página.
     * @param size El tamaño de la página.
     * @return Una página de documentos.
     */
    Page<Documento> obtenerTodosDocumentosPaginados(int page, int size);
}
