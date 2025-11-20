package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.SamePasswordException;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioServiceImpl;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioEstadoPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioPasswordPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioUsernamePatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service.contract.IGestionUsuariosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio para la gestión de usuarios.
 */
@Service
public class GestionUsuarioServiceImpl implements IGestionUsuariosService {

    private final UsuarioServiceImpl usuarioService;
    private final PasswordService passwordService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param usuarioService Servicio para las operaciones de base de datos de usuarios.
     * @param passwordService Servicio para la codificación y verificación de contraseñas.
     */
    public GestionUsuarioServiceImpl(
            UsuarioServiceImpl usuarioService,
            PasswordService passwordService
    ) {
        this.usuarioService = usuarioService;
        this.passwordService = passwordService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarEstadoUsuario(
        UsuarioEstadoPatchDTO estadoDTO
    ) {
        String username = estadoDTO.username().trim();

        // Llama el servicio para buscar el usuario por nombre. No si no lo encuentra
        // devuelve una Exception.
        usuarioService.buscarUsuarioPorNombreUsuario(username);

        if (estadoDTO.enabled()) {
            usuarioService.habilitarUsuarioPorNombreUsuario(username);
        } else {
            usuarioService.deshabilitarUsuarioPorNombreUsuario(username);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarUsernameUsuario(
        UsuarioUsernamePatchDTO usernameDTO
    ) {
        // Llama el servicio para buscar el usuario por nombre. No si no lo encuentra
        // devuelve una Exception.
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(
            usernameDTO.currentUsername().trim()
        );

        usuarioService.actualizarNombreUsuario(
                usuario.getId(),
                usernameDTO.newUsername().trim()
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarPasswordUsuario(
        UsuarioPasswordPatchDTO passwordDTO
    ) {
        String newPlainPassword = passwordDTO.newPlainPassword().trim();

        // Llama el servicio para buscar el usuario por nombre. No si no lo encuentra
        // devuelve una Exception.
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(
                passwordDTO.username().trim()
        );

        if (
            passwordService.verifyPassword(
                newPlainPassword,
                usuario.getPassword_hash()
            )
        ) {
            throw new SamePasswordException(
                "La contraseña no puede ser la misma"
            );
        }

        usuarioService.actualizarContrasenaCodificada(
            usuario.getId(),
            passwordService.hashPassword(newPlainPassword)
        );
    }
}
