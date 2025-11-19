package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e WHERE e.ruc = :ruc")
    Optional<Empresa> findByRuc(@Param("ruc") String ruc);
}
