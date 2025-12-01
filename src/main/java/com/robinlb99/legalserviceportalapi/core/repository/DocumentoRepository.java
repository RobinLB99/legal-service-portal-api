package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Documento.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Documento.
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    /**
     * Actualiza el nombre de un documento específico.
     *
     * @param id El ID del documento a actualizar.
     * @param nameDocument El nuevo nombre para el documento.
     */
    @Modifying
    @Query("UPDATE Documento d SET d.nombre = :nameDocument WHERE d.id = :id")
    void updateDocumentName(Long id, String nameDocument);

    /**
     * Actualiza el tipo de documento de un documento específico.
     *
     * @param id El ID del documento a actualizar.
     * @param typeDocument El nuevo tipo para el documento.
     */
    @Modifying
    @Query(
        "UPDATE Documento d SET d.tipo_documento = :typeDocument WHERE d.id = :id"
    )
    void updateTypeDocumento(Long id, TipoDocumento typeDocument);
}
