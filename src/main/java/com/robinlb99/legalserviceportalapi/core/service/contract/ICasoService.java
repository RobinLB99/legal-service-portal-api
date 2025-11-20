package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz para el servicio de gestión de casos.
 * Define los métodos para operaciones CRUD y de negocio sobre la entidad Caso.
 */
public interface ICasoService {
    /**
     * Crea un nuevo caso en la base de datos.
     *
     * @param nuevoCaso El objeto Caso a crear.
     * @return El Caso guardado.
     */
    Caso crearCaso(Caso nuevoCaso);

    /**
     * Actualiza el estado de un caso existente.
     *
     * @param idCaso          El ID del caso a actualizar.
     * @param nuevoEstadoCaso El nuevo estado del caso.
     */
    void actualizarEstadoCaso(Long idCaso, EstadoCaso nuevoEstadoCaso);

    /**
     * Obtiene un caso por su ID.
     *
     * @param id El ID del caso a obtener.
     * @return El Caso encontrado.
     * @throws CasoNotFoundException si no se encuentra el caso.
     */
    Caso obtenerCasoPorId(Long id);

    /**
     * Obtiene una página de casos filtrados por su estado.
     *
     * @param estado  El estado del caso por el cual filtrar.
     * @param numPage El número de la página a obtener.
     * @param numRow  El número de filas por página.
     * @return Una página de objetos Caso.
     */
    Page<Caso> obtenerCasosPorEstado(
        EstadoCaso estado,
        int numPage,
        int numRow
    );

    /**
     * Obtiene una página de casos pertenecientes a un cliente específico.
     *
     * @param idCliente El ID del cliente.
     * @param numPage   El número de la página a obtener.
     * @param numRow    El número de filas por página.
     * @return Una página de objetos Caso.
     */
    Page<Caso> obtenerCasosPorIdCliente(
        Long idCliente,
        int numPage,
        int numRow
    );

    /**
     * Obtiene una página de casos asignados a un abogado específico.
     *
     * @param idAbogado El ID del abogado.
     * @param numPage   El número de la página a obtener.
     * @param numRow    El número de filas por página.
     * @return Una página de objetos Caso.
     */
    Page<Caso> obtenerCasosPorIdAbogado(
        Long idAbogado,
        int numPage,
        int numRow
    );
}
