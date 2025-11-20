package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de gestión de usuarios.
 * Proporciona la lógica de negocio para las operaciones con usuarios.
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Construye un nuevo UsuarioServiceImpl con el repositorio de usuarios proporcionado.
     *
     * @param usuarioRepository El repositorio de usuarios a utilizar.
     */
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository
            .findById(idUsuario)
            .orElseThrow(() ->
                new UsuarioNotFoundException(
                    "Usuario con ID '" + idUsuario + "' no encontrado"
                )
            );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarContrasenaCodificada(
        Long idUsuario,
        String nuevaContrasenaCodificada
    ) {
        usuarioRepository.updatePasswordEncode(
            idUsuario,
            nuevaContrasenaCodificada
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void actualizarNombreUsuario(Long id, String nuevoUsername) {
        usuarioRepository.updateUsername(id, nuevoUsername);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository
            .findByUsername(nombreUsuario)
            .orElseThrow(() ->
                new UsuarioNotFoundException(
                    "Usuario '" + nombreUsuario + "' no encontrado"
                )
            );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deshabilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.disableUserById(idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deshabilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.disableUserByUsername(nombreUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void habilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.enableUserById(idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void habilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.enableUserByUsername(nombreUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean existeUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsUsuarioByUsername(nombreUsuario);
    }
}
