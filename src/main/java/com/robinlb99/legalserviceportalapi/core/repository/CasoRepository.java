package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Caso.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Caso.
 */
@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
}

