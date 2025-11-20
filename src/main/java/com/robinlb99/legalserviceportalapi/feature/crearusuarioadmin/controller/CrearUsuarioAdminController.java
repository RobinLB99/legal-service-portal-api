package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.controller;

import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminPasswordDTO;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.service.CrearUsuarioAdminServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para la creación del usuario administrador.
 */
@RestController
@RequestMapping("/api/admin-user")
public class CrearUsuarioAdminController {

    private final CrearUsuarioAdminServiceImpl crearUsuarioAdminService;

    /**
     * Constructor del controlador.
     *
     * @param crearUsuarioAdminService Servicio para la creación del usuario administrador.
     */
    public CrearUsuarioAdminController(
        CrearUsuarioAdminServiceImpl crearUsuarioAdminService
    ) {
        this.crearUsuarioAdminService = crearUsuarioAdminService;
    }

    /**
     * Endpoint para crear el usuario administrador.
     *
     * @param adminPasswordDTO DTO con la contraseña en texto plano para el administrador.
     * @return ResponseEntity con el DTO del usuario administrador creado y el estado HTTP 201 (Created).
     */
    @PostMapping("/")
    public ResponseEntity<UsuarioAdminResponseDTO> crearUsuarioAdmin(
        @Valid @RequestBody UsuarioAdminPasswordDTO adminPasswordDTO
    ) {
        UsuarioAdminResponseDTO admin =
            crearUsuarioAdminService.crearUsuarioAdmin(adminPasswordDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }
}
