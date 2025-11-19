package com.robinlb99.legalserviceportalapi.feature.registrarse.controller;

import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.RegistrarseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para el registro de nuevos usuarios.
 * Proporciona endpoints para registrar clientes de tipo persona natural y empresa.
 */
@RestController
@RequestMapping("/api/registrarse")
public class RegistroController {

    private final RegistrarseServiceImpl registrarseService;

    /**
     * Construye un nuevo RegistroController con el servicio de registro proporcionado.
     *
     * @param registrarseService El servicio de registro a utilizar.
     */
    public RegistroController(RegistrarseServiceImpl registrarseService) {
        this.registrarseService = registrarseService;
    }

    /**
     * Registra un nuevo cliente de tipo persona natural.
     *
     * @param dto Los datos de la persona natural a registrar.
     * @return Un ResponseEntity con los datos de la persona natural registrada y el estado HTTP CREATED.
     */
    @PostMapping("/personanatural")
    public ResponseEntity<
        DatosPersonaNaturalResponseDTO
    > registrarseClienteNatural(
        @Valid @RequestBody DatosPersonaNaturalRequestDTO dto
    ) {
        DatosPersonaNaturalResponseDTO responseDTO =
            registrarseService.registrarsePersonaNatural(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    /**
     * Registra una nueva empresa.
     *
     * @param dto Los datos de la empresa a registrar.
     * @return Un ResponseEntity con los datos de la empresa registrada y el estado HTTP CREATED.
     */
    @PostMapping("/empresa")
    public ResponseEntity<DatosEmpresaResponseDTO> registrarseEmpresa(
        @Valid @RequestBody DatosEmpresaRequestDTO dto
    ) {
        DatosEmpresaResponseDTO responseDTO =
            registrarseService.registrarEmpresa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/abogado")
    public ResponseEntity<DatosAbogadoResponseDTO> registrarse(
        @Valid @RequestBody DatosAbogadoRequestDTO dto
    ) {
        DatosAbogadoResponseDTO responseDTO =
            registrarseService.registrarAbogado(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
