package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repositorio para la entidad Empresa.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Empresa.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    /**
     * Busca una empresa por su RUC.
     *
     * @param ruc El RUC de la empresa a buscar.
     * @return Un Optional que contiene la empresa si se encuentra, o un Optional vacío si no.
     */
    @Query("SELECT e FROM Empresa e WHERE e.ruc = :ruc")
    Optional<Empresa> findByRuc(@Param("ruc") String ruc);
}

