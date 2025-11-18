package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioSerivceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioSerivceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new UsuarioNotFoundException("Usuario con ID '" +
                        idUsuario + "' no encontrado")
        );
    }

    @Override
    @Transactional
    public void eliminarUsuarioPorId(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    @Transactional
    public void actualizarContrasenaCodificada(Long idUsuario, String nuevaContrasenaCodificada) {
        usuarioRepository.updatePasswordEncode(idUsuario, nuevaContrasenaCodificada);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByUsername(nombreUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(
                        "Usuario '" + nombreUsuario + "' no encontrado"
                )
        );
    }

    @Override
    @Transactional
    public void deshabilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.disableUserById(idUsuario);
    }

    @Override
    @Transactional
    public void deshabilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.disableUserByUsername(nombreUsuario);
    }

    @Override
    @Transactional
    public void habilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.enableUserById(idUsuario);
    }

    @Override
    @Transactional
    public void habilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.enableUserByUsername(nombreUsuario);
    }

    @Override
    @Transactional
    public boolean existeUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsUsuarioByUsername(nombreUsuario);
    }
}
