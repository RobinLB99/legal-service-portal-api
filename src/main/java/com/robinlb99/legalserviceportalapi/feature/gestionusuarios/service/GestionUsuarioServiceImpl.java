package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.exception.SamePasswordException;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
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

    private final UsuarioRepository usuarioRepository;
    private final PasswordService passwordService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param usuarioRepository Repositorio para las operaciones de base de datos de usuarios.
     * @param passwordService   Servicio para la codificación y verificación de contraseñas.
     */
    public GestionUsuarioServiceImpl(
        UsuarioRepository usuarioRepository,
        PasswordService passwordService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordService = passwordService;
    }

    /**
     * {@inheritDoc}
     * @throws UsuarioNotFoundException si el usuario con el ID proporcionado no existe.
     */
    @Override
    @Transactional
    public void actualizarEstadoUsuario(
        Long id,
        UsuarioEstadoPatchDTO estadoDTO
    ) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException(
                "Usuario con ID '" + id + "' no encontrado"
            );
        }

        if (estadoDTO.enabled()) {
            usuarioRepository.enableUserById(id);
        } else {
            usuarioRepository.disableUserById(id);
        }
    }

    /**
     * {@inheritDoc}
     * @throws UsuarioNotFoundException si el usuario con el ID proporcionado no existe.
     */
    @Override
    @Transactional
    public void actualizarUsernameUsuario(
        Long id,
        UsuarioUsernamePatchDTO usernameDTO
    ) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException(
                "Usuario con ID '" + id + "' no encontrado"
            );
        }
        usuarioRepository.updateUsername(id, usernameDTO.username().trim());
    }

    /**
     * {@inheritDoc}
     * @throws UsuarioNotFoundException si el usuario con el ID proporcionado no existe.
     * @throws SamePasswordException si la nueva contraseña es igual a la actual.
     */
    @Override
    @Transactional
    public void actualizarPasswordUsuario(
        Long id,
        UsuarioPasswordPatchDTO passwordDTO
    ) {
        String passwordHash = usuarioRepository
            .findById(id)
            .orElseThrow(() ->
                new UsuarioNotFoundException(
                    "Usuario con ID '" + id + "' no encontrado"
                )
            )
            .getPassword_hash();

        if (
            passwordService.verifyPassword(
                passwordDTO.plainPassword(),
                passwordHash
            )
        ) {
            throw new SamePasswordException(
                "La contraseña no puede ser la misma"
            );
        }

        usuarioRepository.updatePasswordEncode(
            id,
            passwordService.hashPassword(passwordDTO.plainPassword())
        );
    }
}
