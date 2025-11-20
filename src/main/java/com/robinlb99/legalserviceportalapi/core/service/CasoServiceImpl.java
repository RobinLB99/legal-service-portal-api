package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import com.robinlb99.legalserviceportalapi.core.model.exception.CasoNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.CasoRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.ICasoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de gestión de casos.
 * Proporciona la lógica de negocio para las operaciones sobre la entidad Caso.
 */
@Service
public class CasoServiceImpl implements ICasoService {

    private final CasoRepository casoRepository;

    public CasoServiceImpl(CasoRepository casoRepository) {
        this.casoRepository = casoRepository;
    }

    /**
     * Crea un nuevo caso en la base de datos.
     * @param nuevoCaso El objeto Caso a crear.
     * @return El Caso guardado.
     */
    @Override
    @Transactional
    public Caso crearCaso(Caso nuevoCaso) {
        return casoRepository.save(nuevoCaso);
    }

    /**
     * Actualiza el estado de un caso existente.
     * @param idCaso El ID del caso a actualizar.
     * @param nuevoEstadoCaso El nuevo estado del caso.
     */
    @Override
    @Transactional
    public void actualizarEstadoCaso(Long idCaso, EstadoCaso nuevoEstadoCaso) {
        casoRepository.updateStateCaso(idCaso, nuevoEstadoCaso);
    }

    /**
     * Obtiene un caso por su ID.
     *
     * @param id El ID del caso a obtener.
     * @return El Caso encontrado.
     * @throws CasoNotFoundException si no se encuentra el caso.
     */
    @Override
    @Transactional(readOnly = true)
    public Caso obtenerCasoPorId(Long id) {
        return casoRepository
            .findById(id)
            .orElseThrow(() ->
                new CasoNotFoundException(
                    "Caso con ID '" + id + "' no encontrado"
                )
            );
    }

    /**
     * Obtiene una página de casos filtrados por su estado.
     *
     * @param estado El estado del caso por el cual filtrar.
     * @param numPage El número de la página a obtener.
     * @param numRow El número de filas por página.
     * @return Una página de objetos Caso.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Caso> obtenerCasosPorEstado(
        EstadoCaso estado,
        int numPage,
        int numRow
    ) {
        Pageable pageable = PageRequest.of(numPage, numRow);
        return casoRepository.findAllByEstado(estado, pageable);
    }

    /**
     * Obtiene una página de casos pertenecientes a un cliente específico.
     * @param idCliente El ID del cliente.
     * @param numPage El número de la página a obtener.
     * @param numRow El número de filas por página.
     * @return Una página de objetos Caso.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Caso> obtenerCasosPorIdCliente(
        Long idCliente,
        int numPage,
        int numRow
    ) {
        Pageable pageable = PageRequest.of(numPage, numRow);
        return casoRepository.findAllByIdCliente(idCliente, pageable);
    }

    /**
     * Obtiene una página de casos asignados a un abogado específico.
     * @param idAbogado El ID del abogado.
     * @param numPage El número de la página a obtener.
     * @param numRow El número de filas por página.
     * @return Una página de objetos Caso.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Caso> obtenerCasosPorIdAbogado(
        Long idAbogado,
        int numPage,
        int numRow
    ) {
        Pageable pageable = PageRequest.of(numPage, numRow);
        return casoRepository.findAllByIdAbogado(idAbogado, pageable);
    }
}
