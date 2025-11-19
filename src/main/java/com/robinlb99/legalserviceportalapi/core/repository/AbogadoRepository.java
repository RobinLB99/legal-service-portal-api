package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Abogado.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Abogado.
 */
@Repository
public interface AbogadoRepository extends JpaRepository<Abogado, Long> {}

