package com.robinlb99.legalserviceportalapi.feature.registrarse.controller;

import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.RegistrarseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registrarse")
public class RegistroController {

    private final RegistrarseServiceImpl registrarseService;

    public RegistroController(RegistrarseServiceImpl registrarseService) {
        this.registrarseService = registrarseService;
    }

    @PostMapping("/personanatural")
    public ResponseEntity<DatosPersonaNaturalResponseDTO> registrarseClienteNatural(
        @Valid @RequestBody DatosPersonaNaturalRequestDTO dto
    ) {
        return registrarseService.registrarsePersonaNatural(dto);
    }

    @PostMapping("/empresa")
    public ResponseEntity<DatosEmpresaResponseDTO> registrarseEmpresa(
            @Valid @RequestBody DatosEmpresaRequestDTO dto
    ) {
        return null;
    }

    @PostMapping("/Abogado")
    public ResponseEntity<DatosAbogadoResponseDTO> registrarse(
            @Valid @RequestBody DatosAbogadoRequestDTO dto
    ) {
        return null;
    }
}
