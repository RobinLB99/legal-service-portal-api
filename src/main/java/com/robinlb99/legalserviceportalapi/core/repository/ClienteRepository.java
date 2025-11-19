package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Cliente.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Cliente.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

