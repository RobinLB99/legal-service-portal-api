package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.service;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.enums.Role;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioAdminAlreadyExistsException;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioServiceImpl;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminPasswordDTO;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.mapper.UsuarioAdminMapper;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.service.contract.ICrearUsuarioAdminService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para crear el usuario administrador.
 */
@Service
public class CrearUsuarioAdminServiceImpl implements ICrearUsuarioAdminService {

    private final UsuarioAdminMapper usuarioAdminMapper;
    private final PasswordService passwordService;
    private final UsuarioServiceImpl usuarioService;

    /**
     * Constructor del servicio.
     *
     * @param usuarioAdminMapper Mapeador para convertir entre DTO y entidad de usuario.
     * @param passwordService    Servicio para manejar contraseñas.
     * @param usuarioService     Servicio para la gestión de usuarios.
     */
    public CrearUsuarioAdminServiceImpl(
        UsuarioAdminMapper usuarioAdminMapper,
        PasswordService passwordService,
        UsuarioServiceImpl usuarioService
    ) {
        this.usuarioAdminMapper = usuarioAdminMapper;
        this.passwordService = passwordService;
        this.usuarioService = usuarioService;
    }

    /**
     * Crea el usuario administrador si no existe.
     *
     * @param adminPasswordDTO DTO con la contraseña en texto plano para el administrador.
     * @return UsuarioAdminResponseDTO con la información del usuario administrador creado.
     * @throws UsuarioAdminAlreadyExistsException si el usuario 'admin' ya existe.
     */
    @Override
    public UsuarioAdminResponseDTO crearUsuarioAdmin(
        UsuarioAdminPasswordDTO adminPasswordDTO
    ) {
        if (usuarioService.existeUsuarioPorNombreUsuario("admin")) {
            throw new UsuarioAdminAlreadyExistsException(
                "El usuario Administrador ya existe"
            );
        }

        Usuario usuario = new Usuario();
        usuario.setUsername("admin");
        usuario.setPassword_hash(
            passwordService.hashPassword(adminPasswordDTO.plainPassword())
        );
        usuario.setRol(Role.ADMIN);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setActivo(true);

        usuario = usuarioService.crearUsuario(usuario);

        return usuarioAdminMapper.toDTO(usuario);
    }
}
