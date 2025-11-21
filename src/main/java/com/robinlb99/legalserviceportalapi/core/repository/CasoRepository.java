package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Repositorio para la entidad Caso.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Caso.
 */
@Repository
public interface CasoRepository extends JpaRepository<Caso, Long> {
    /**
     * Actualiza el estado de un caso específico.
     *
     * @param idCaso     El ID del caso a actualizar.
     * @param estadoCaso El nuevo estado para el caso.
     */
    @Modifying
    @Query("UPDATE Caso c SET c.estado_caso = :estadoCaso WHERE c.id = :id")
    void updateStateCaso(Long idCaso, EstadoCaso estadoCaso);

    /**
     * Actualiza el título de un caso específico.
     *
     * @param idCaso     El ID del caso a actualizar.
     * @param tituloCaso El nuevo título para el caso.
     */
    @Modifying
    @Query("UPDATE Caso c SET c.titulo = :tituloCaso WHERE c.id = :idCaso")
    void updateCasoTitle(Long idCaso, String tituloCaso);

    /**
     * Actualiza la descripción de un caso específico.
     *
     * @param idCaso          El ID del caso a actualizar.
     * @param descripcionCaso La nueva descripción para el caso.
     */
    @Modifying
    @Query(
        "UPDATE Caso c SET c.descripcion = :descripcionCaso WHERE c.id = :idCaso"
    )
    void updateDescripcionCaso(Long idCaso, String descripcionCaso);

    /**
     * Busca todos los casos que coinciden con un estado de caso específico y devuelve una
     * página de resultados.
     *
     * @param estadoCaso El estado del caso a buscar.
     * @param pageable   La información de paginación.
     * @return Una página de entidades Caso.
     */
    @Query("SELECT c FROM Caso c WHERE c.estado_caso = :estadoCaso")
    Page<Caso> findAllByEstado(EstadoCaso estadoCaso, Pageable pageable);

    /**
     * Busca todos los casos asociados a un ID de cliente específico y devuelve una página
     * de resultados.
     *
     * @param idCliente El ID del cliente para el cual buscar los casos.
     * @param pageable  La información de paginación.
     * @return Una página de entidades Caso.
     */
    @Query("SELECT c FROM Caso c WHERE c.cliente.id = :idCliente")
    Page<Caso> findAllByIdCliente(Long idCliente, Pageable pageable);

    /**
     * Busca todos los casos asociados a un ID de abogado específico y devuelve una página
     * de resultados.
     *
     * @param idAbogado El ID del abogado para el cual buscar los casos.
     * @param pageable  La información de paginación.
     * @return Una página de entidades Caso.
     */
    @Query(
        "SELECT c FROM Caso c WHERE c.abogado.id = :idAbogado"
    )
    Page<Caso> findAllByIdAbogado(Long idAbogado, Pageable pageable);

    /**
     * Actualiza la fecha de actualización de un caso específico.
     *
     * @param id El ID del caso a actualizar.
     * @param fechaActualizacion La nueva fecha de actualización.
     */
    @Modifying
    @Query(
        "UPDATE Caso c SET c.fecha_actualizacion = :fechaActualizacion WHERE c.id = :id"
    )
    void updateFechaActualizacion(Long id, LocalDate fechaActualizacion);
}
