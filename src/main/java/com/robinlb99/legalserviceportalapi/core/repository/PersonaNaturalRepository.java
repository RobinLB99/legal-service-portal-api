package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad PersonaNatural.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad PersonaNatural.
 */
@Repository
public interface PersonaNaturalRepository extends JpaRepository<PersonaNatural, Long> {

}

