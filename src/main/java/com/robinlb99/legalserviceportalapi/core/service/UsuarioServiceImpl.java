package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.domain.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.domain.enums.Role;
import com.robinlb99.legalserviceportalapi.core.domain.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.core.dto.UsuarioRequestDTO;
import com.robinlb99.legalserviceportalapi.core.mapper.UsuarioMapper;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IUsuarioService;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private PasswordService passwordService;
    private UsuarioRepository repository;

    public UsuarioServiceImpl(
        PasswordService passwordService,
        UsuarioMapper usuarioMapper,
        UsuarioRepository repository
    ) {
        this.passwordService = passwordService;
        this.usuarioMapper = usuarioMapper;
        this.repository = repository;
    }

    @Override
    @Transactional
    public Usuario crearUsuario(UsuarioRequestDTO usuarioRequest) {
        String passwordHashed = passwordService.hashPassword(
            usuarioRequest.password()
        );
        Role rol = usuarioRequest.rol().equals("ADMIN")
            ? Role.ADMIN
            : Role.USUARIO;

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);
        usuario.setPassword_hash(passwordHashed);
        usuario.setActivo(true);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setRol(rol);

        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void actualizarPassword(Long id, String nuevoPassword) {
        String passwordHashed = passwordService.hashPassword(nuevoPassword);
        repository.updatePasswordEncode(id, passwordHashed);
    }

    @Override
    public void actualizarPerfilUsuario(Long idUsuario) {
        // TODO Auto-generated method stub
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioPorId(Long id) {
        return repository
            .findById(id)
            .orElseThrow(() ->
                new UsuarioNotFoundException(
                    "No se encontro el usuario con el ID: " + id
                )
            );
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerUsuarioPorUsername(String username) {
        return repository
            .findByUsername(username)
            .orElseThrow(() ->
                new UsuarioNotFoundException(
                    "No se encontro el usuario: " + username
                )
            );
    }

    @Override
    @Transactional
    public void desactivarUsuarioPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNotFoundException(
                "Usuario con ID '" + id + "', no encontrado."
            );
        }
        repository.disableUserById(id);
    }

    @Override
    @Transactional
    public void desactivarUsuarioPorUsername(String username) {
        if (repository.existsUsuarioByUsername(username)) {
            throw new UsuarioNotFoundException(
                "El usuario '" + username + "' no existe."
            );
        }
        repository.disableUserByUsername(username);
    }

    @Override
    @Transactional
    public void activarUsuarioPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNotFoundException(
                "Usuario con ID '" + id + "', no encontrado."
            );
        }
        repository.enableUserById(id);
    }

    @Override
    @Transactional
    public void activarUsuarioPorUsername(String username) {
        if (repository.existsUsuarioByUsername(username)) {
            throw new UsuarioNotFoundException(
                "El usuario '" + username + "' no existe."
            );
        }
        repository.enableUserByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> obtenerUsuariosPaginados(
        int numeroPagina,
        int tamanioPagina
    ) {
        Pageable pageable = PageRequest.of(
            numeroPagina,
            tamanioPagina,
            Sort.by("nombre").ascending()
        );
        return repository.findAll(pageable);
    }
}
