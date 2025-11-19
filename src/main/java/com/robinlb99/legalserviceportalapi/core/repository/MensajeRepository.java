package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Mensaje.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Mensaje.
 */
@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}

