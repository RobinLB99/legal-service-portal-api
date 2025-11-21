package com.robinlb99.legalserviceportalapi.feature.gestioncasos.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import com.robinlb99.legalserviceportalapi.core.service.CasoServiceImpl;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto.*;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.helper.CasoHelper;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.mapper.CasoMapper;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.service.contract.IGestionCasosService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para la gestión de casos.
 */
@Service
public class GestionCasosServiceImpl implements IGestionCasosService {

    private final CasoServiceImpl casoService;
    private final CasoMapper casoMapper;
    private final CasoHelper casoHelper;

    public GestionCasosServiceImpl(
        CasoServiceImpl casoService,
        CasoMapper casoMapper,
        CasoHelper casoHelper
    ) {
        this.casoService = casoService;
        this.casoMapper = casoMapper;
        this.casoHelper = casoHelper;
    }

    /**
     * Crea un nuevo caso.
     *
     * @param casoDTO DTO para la creación del caso.
     * @return DTO de respuesta del caso creado.
     */
    @Override
    @Transactional
    public CasoResponseDTO crearCaso(CasoRequestDTO casoDTO) {
        Caso nuevoCaso = casoMapper.toEntity(casoDTO);
        nuevoCaso = casoService.crearCaso(nuevoCaso);
        return casoMapper.toDTO(nuevoCaso);
    }

    /**
     * Obtiene un caso por su ID.
     *
     * @param idCaso ID del caso a obtener.
     * @return DTO de respuesta del caso.
     */
    @Override
    @Transactional(readOnly = true)
    public CasoResponseDTO obtenerCasoPorId(Long idCaso) {
        Caso caso = casoService.obtenerCasoPorId(idCaso);
        return casoMapper.toDTO(caso);
    }

    /**
     * Actualiza el estado de un caso.
     *
     * @param idCaso    ID del caso a actualizar.
     * @param estadoDTO DTO con el nuevo estado del caso.
     */
    @Override
    @Transactional
    public void actualizarEstadoCaso(Long idCaso, CasoEstadoDTO estadoDTO) {
        EstadoCaso estado = casoHelper.obtenerEstadoCaso(
            estadoDTO.nuevoEstado()
        );
        casoService.actualizarEstadoCaso(idCaso, estado);
    }

    /**
     * Actualiza el título de un caso.
     *
     * @param idCaso    ID del caso a actualizar.
     * @param tituloDTO DTO con el nuevo título del caso.
     */
    @Override
    @Transactional
    public void actualizarTituloCaso(Long idCaso, CasoTituloDTO tituloDTO) {
        casoService.actualizarTituloCaso(idCaso, tituloDTO.titulo());
    }

    /**
     * Actualiza la descripción de un caso.
     *
     * @param idCaso        ID del caso a actualizar.
     * @param descripcioDTO DTO con la nueva descripción del caso.
     */
    @Override
    @Transactional
    public void actualizarDescripcionCaso(
        Long idCaso,
        CasoDescripcioDTO descripcioDTO
    ) {
        casoService.actualizarDescripcionCaso(
            idCaso,
            descripcioDTO.descripcion()
        );
    }

    @Override
    @Transactional
    public void cerrarCaso(Long idCaso) {
        casoService.registrarFechaAtualizacionCaso(idCaso);
        casoService.actualizarEstadoCaso(idCaso, EstadoCaso.CERRADO);
    }

    /**
     * Obtiene una página de casos por estado.
     *
     * @param estadoCaso   String con el estado del caso a obtener.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CasoResponseDTO> obtenerCasosPorEstado(
        String estadoCaso,
        int numPagina,
        int tamanoPagina
    ) {
        EstadoCaso estado = casoHelper.obtenerEstadoCaso(estadoCaso);
        return casoService
            .obtenerCasosPorEstado(estado, numPagina, tamanoPagina)
            .map(casoMapper::toDTO);
    }

    /**
     * Obtiene una página de casos por ID de cliente.
     *
     * @param idCliente    ID del cliente.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CasoResponseDTO> obtenerCasosPorIdCliente(
        Long idCliente,
        int numPagina,
        int tamanoPagina
    ) {
        return casoService
            .obtenerCasosPorIdCliente(idCliente, numPagina, tamanoPagina)
            .map(casoMapper::toDTO);
    }

    /**
     * Obtiene una página de casos por ID de abogado.
     *
     * @param idAbogado    ID del abogado.
     * @param numPagina    Número de la página a obtener.
     * @param tamanoPagina Tamaño de la página.
     * @return Página de DTOs de respuesta de casos.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CasoResponseDTO> obtenerCasosPorIdAbogado(
        Long idAbogado,
        int numPagina,
        int tamanoPagina
    ) {
        return casoService
            .obtenerCasosPorIdAbogado(idAbogado, numPagina, tamanoPagina)
            .map(casoMapper::toDTO);
    }
}
