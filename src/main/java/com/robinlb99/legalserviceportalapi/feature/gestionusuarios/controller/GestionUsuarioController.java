package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.controller;

import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioEstadoPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioPasswordPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioUsernamePatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service.GestionUsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la gestión de usuarios.
 * Proporciona endpoints para actualizar atributos específicos de un usuario.
 */
@RestController
@RequestMapping("/api/usuarios")
public class GestionUsuarioController {

    private final GestionUsuarioServiceImpl gestionUsuarioService;

    /**
     * Constructor para inyección de dependencias.
     *
     * @param gestionUsuarioService El servicio que gestiona la lógica de negocio de usuarios.
     */
    public GestionUsuarioController(
        GestionUsuarioServiceImpl gestionUsuarioService
    ) {
        this.gestionUsuarioService = gestionUsuarioService;
    }

    /**
     * Actualiza el estado de habilitación de un usuario.
     *
     * @param estadoDTO DTO que contiene el usuario a modificar y nuevo estado de habilitación.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/estado")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> actualizarEstadoUsuario(
        @Valid @RequestBody UsuarioEstadoPatchDTO estadoDTO
    ) {
        gestionUsuarioService.actualizarEstadoUsuario(estadoDTO);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza el nombre de usuario de un usuario.
     *
     * @param usernameDTO DTO que contiene el nuevo nombre de usuario.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/username")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> actualizarUsernameUsuario(
        @Valid @RequestBody UsuarioUsernamePatchDTO usernameDTO
    ) {
        gestionUsuarioService.actualizarUsernameUsuario(usernameDTO);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza la contraseña de un usuario.
     *
     * @param passwordDTO DTO que contiene el nombre usuario a modificar y la nueva contraseña.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/password")
    @PreAuthorize(
        "hasAnyRole('CLIENTE', 'ABOGADO')"
    )
    public ResponseEntity<Void> actualizarPassword(
        @Valid @RequestBody UsuarioPasswordPatchDTO passwordDTO
    ) {
        gestionUsuarioService.actualizarPasswordUsuario(passwordDTO);
        return ResponseEntity.noContent().build();
    }
}
