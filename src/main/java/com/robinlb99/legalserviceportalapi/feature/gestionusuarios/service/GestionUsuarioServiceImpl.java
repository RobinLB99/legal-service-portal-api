package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.SamePasswordException;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
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
        String username,
        UsuarioEstadoPatchDTO estadoDTO
    ) {
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);

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
        String username,
        UsuarioUsernamePatchDTO usernameDTO
    ) {
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);
        usuarioService.actualizarNombreUsuario(
                usuario.getId(),
                usernameDTO.username().trim()
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarPasswordUsuario(
        String username,
        UsuarioPasswordPatchDTO passwordDTO
    ) {
        Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(username);

        if (
            passwordService.verifyPassword(
                passwordDTO.plainPassword(),
                usuario.getPassword_hash()
            )
        ) {
            throw new SamePasswordException(
                "La contraseña no puede ser la misma"
            );
        }

        usuarioService.actualizarContrasenaCodificada(
            usuario.getId(),
            passwordService.hashPassword(passwordDTO.plainPassword())
        );
    }
}
