package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.controller;

import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioEstadoPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioPasswordPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioUsernamePatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service.GestionUsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
     * @param id El ID del usuario.
     * @param estadoDTO DTO con el nuevo estado.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> actualizarEstadoUsuario(
        @PathVariable Long id,
        @Valid @RequestBody UsuarioEstadoPatchDTO estadoDTO
    ) {
        gestionUsuarioService.actualizarEstadoUsuario(id, estadoDTO);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza el nombre de usuario de un usuario.
     *
     * @param id El ID del usuario.
     * @param usernameDTO DTO con el nuevo nombre de usuario.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/{id}/username")
    public ResponseEntity<Void> actualizarUsernameUsuario(
        @PathVariable Long id,
        @Valid @RequestBody UsuarioUsernamePatchDTO usernameDTO
    ) {
        gestionUsuarioService.actualizarUsernameUsuario(id, usernameDTO);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza la contraseña de un usuario.
     *
     * @param id El ID del usuario.
     * @param passwordDTO DTO con la nueva contraseña.
     * @return ResponseEntity con estado 204 No Content si la operación es exitosa.
     */
    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> actualizarPassword(
        @PathVariable Long id,
        @Valid @RequestBody UsuarioPasswordPatchDTO passwordDTO
    ) {
        gestionUsuarioService.actualizarPasswordUsuario(id, passwordDTO);
        return ResponseEntity.noContent().build();
    }
}
