package com.robinlb99.legalserviceportalapi.feature.gestioncasos.service.contract;

import com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto.*;
import org.springframework.data.domain.Page;

/**
 * Interfaz para el servicio de gestión de casos.
 */
public interface IGestionCasosService {
    /**
     * Crea un nuevo caso.
     *
     * @param caso DTO para la creación del caso.
     * @return DTO de respuesta del caso creado.
     */
    CasoResponseDTO crearCaso(CasoRequestDTO caso);

    /**
     * Obtiene un caso por su ID.
     *
     * @param idCaso ID del caso a obtener.
     * @return DTO de respuesta del caso.
     */
    CasoResponseDTO obtenerCasoPorId(Long idCaso);

    /**
     * Actualiza el estado de un caso.
     *
     * @param idCaso    ID del caso a actualizar.
     * @param estadoDTO DTO con el nuevo estado del caso.
     */
    void actualizarEstadoCaso(Long idCaso, CasoEstadoDTO estadoDTO);

    /**
     * Actualiza el título de un caso.
     *
     * @param idCaso    ID del caso a actualizar.
     * @param tituloDTO DTO con el nuevo título del caso.
     */
    void actualizarTituloCaso(Long idCaso, CasoTituloDTO tituloDTO);

    /**
     * Actualiza la descripción de un caso.
     *
     * @param idCaso        ID del caso a actualizar.
     * @param descripcioDTO DTO con la nueva descripción del caso.
     */
    void actualizarDescripcionCaso(
        Long idCaso,
        CasoDescripcioDTO descripcioDTO
    );

    void cerrarCaso(Long idCaso);

    /**
     * Obtiene una página de casos por estado.
     *
     * @param estadoCaso   String con el estado de los casos a obtener.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    Page<CasoResponseDTO> obtenerCasosPorEstado(
        String estadoCaso,
        int numPagina,
        int tamanoPagina
    );

    /**
     * Obtiene una página de casos por ID de cliente.
     *
     * @param idClienteDTO ID del cliente.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    Page<CasoResponseDTO> obtenerCasosPorIdCliente(
        Long idClienteDTO,
        int numPagina,
        int tamanoPagina
    );

    /**
     * Obtiene una página de casos por ID de abogado.
     *
     * @param idAbogadoDTO ID del abogado.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    Page<CasoResponseDTO> obtenerCasosPorIdAbogado(
        Long idAbogadoDTO,
        int numPagina,
        int tamanoPagina
    );
}
