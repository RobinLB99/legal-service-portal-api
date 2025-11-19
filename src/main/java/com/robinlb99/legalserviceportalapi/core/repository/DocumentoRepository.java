package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Documento.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Documento.
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}

