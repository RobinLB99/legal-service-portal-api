package com.robinlb99.legalserviceportalapi.feature.gestioncasos.controller;

import com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto.*;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.service.GestionCasosServiceImpl;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la gestión de casos.
 */
@RestController
@RequestMapping("/api/casos")
public class GestionCasosController {

    private final GestionCasosServiceImpl gestionCasosService;

    public GestionCasosController(GestionCasosServiceImpl gestionCasosService) {
        this.gestionCasosService = gestionCasosService;
    }

    /**
     * Crea un nuevo caso.
     *
     * @param request El DTO con la información del caso a crear.
     * @return El DTO del caso creado.
     */
    @PostMapping("/")
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<CasoResponseDTO> createCaso(
        @Valid @RequestBody CasoRequestDTO request
    ) {
        CasoResponseDTO dto = gestionCasosService.crearCaso(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    /**
     * Obtiene un caso por su ID.
     *
     * @param id El ID del caso.
     * @return El DTO del caso.
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ABOGADO', 'ADMIN')")
    public ResponseEntity<CasoResponseDTO> getCaso(@PathVariable Long id) {
        CasoResponseDTO dto = gestionCasosService.obtenerCasoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    /**
     * Actualiza el estado de un caso.
     *
     * @param id      El ID del caso.
     * @param request El DTO con el nuevo estado.
     * @return Una respuesta vacía.
     */
    @PatchMapping("/{id}/estado")
    @PreAuthorize("hasRole('ABOGADO')")
    public ResponseEntity<Void> updateEstado(
        @PathVariable Long id,
        @Valid @RequestBody CasoEstadoDTO request
    ) {
        gestionCasosService.actualizarEstadoCaso(id, request);
        return ResponseEntity.noContent().build();
    }

    /**
     * Cierra un caso.
     *
     * @param id El ID del caso a cerrar.
     * @return Una respuesta vacía.
     */
    @PatchMapping("/{id}/cerrar")
    @PreAuthorize("hasRole('ABOGADO')")
    public ResponseEntity<Void> closeCaso(@PathVariable Long id) {
        gestionCasosService.cerrarCaso(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza el título de un caso.
     *
     * @param id      El ID del caso.
     * @param request El DTO con el nuevo título.
     * @return Una respuesta vacía.
     */
    @PatchMapping("/{id}/titulo")
    @PreAuthorize("hasRole('ABOGADO')")
    public ResponseEntity<Void> updateTitulo(
        @PathVariable Long id,
        @Valid @RequestBody CasoTituloDTO request
    ) {
        gestionCasosService.actualizarTituloCaso(id, request);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza la descripción de un caso.
     *
     * @param id      El ID del caso.
     * @param request El DTO con la nueva descripción.
     * @return Una respuesta vacía.
     */
    @PatchMapping("/{id}/descripcion")
    @PreAuthorize("hasRole('ABOGADO')")
    public ResponseEntity<Void> updateDescripcion(
        @PathVariable Long id,
        @Valid @RequestBody CasoDescripcioDTO request
    ) {
        gestionCasosService.actualizarDescripcionCaso(id, request);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene una página de casos por su estado.
     *
     * @param estado      El estado de los casos a buscar.
     * @param numPagina   El número de la página a obtener.
     * @param tamanio     El tamaño de la página.
     * @return Una página de DTOs de casos.
     */
    @GetMapping("/estado/{estado}")
    @PreAuthorize("hasAnyRole('CLIENTE','ABOGADO', 'ADMIN')")
    public ResponseEntity<Page<CasoResponseDTO>> getCasoByEstado(
        @PathVariable String estado,
        @PathParam("pag") int numPagina,
        @PathParam("size") int tamanio
    ) {
        Page<CasoResponseDTO> casos = gestionCasosService.obtenerCasosPorEstado(
            estado,
            numPagina,
            tamanio
        );
        return ResponseEntity.status(HttpStatus.OK).body(casos);
    }

    /**
     * Obtiene una página de casos por el ID del cliente.
     *
     * @param clienteId El ID del cliente.
     * @param numPagina El número de la página a obtener.
     * @param tamanio   El tamaño de la página.
     * @return Una página de DTOs de casos.
     */
    @GetMapping("/cliente/{clienteId}")
    @PreAuthorize("hasAnyRole('CLIENTE','ABOGADO', 'ADMIN')")
    public ResponseEntity<Page<CasoResponseDTO>> getCasosByClienteId(
        @PathVariable Long clienteId,
        @PathParam("pag") int numPagina,
        @PathParam("size") int tamanio
    ) {
        Page<CasoResponseDTO> casos =
            gestionCasosService.obtenerCasosPorIdCliente(
                clienteId,
                numPagina,
                tamanio
            );
        return ResponseEntity.status(HttpStatus.OK).body(casos);
    }

    /**
     * Obtiene una página de casos por el ID del abogado.
     *
     * @param abogadoId El ID del abogado.
     * @param numPagina El número de la página a obtener.
     * @param tamanio   El tamaño de la página.
     * @return Una página de DTOs de casos.
     */
    @GetMapping("/abogado/{abogadoId}")
    @PreAuthorize("hasAnyRole('ABOGADO', 'ADMIN')")
    public ResponseEntity<Page<CasoResponseDTO>> getCasosByAbogadoId(
        @PathVariable Long abogadoId,
        @PathParam("pag") int numPagina,
        @PathParam("size") int tamanio
    ) {
        Page<CasoResponseDTO> casos =
            gestionCasosService.obtenerCasosPorIdAbogado(
                abogadoId,
                numPagina,
                tamanio
            );
        return ResponseEntity.status(HttpStatus.OK).body(casos);
    }
}
