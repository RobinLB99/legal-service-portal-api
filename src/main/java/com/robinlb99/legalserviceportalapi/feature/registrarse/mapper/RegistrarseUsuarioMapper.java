package com.robinlb99.legalserviceportalapi.feature.registrarse.mapper;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.enums.Role;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosAbogadoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosEmpresaRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosPersonaNaturalRequestDTO;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

/**
 * Mapper para el registro de un usuario.
 * Convierte DTOs a entidades Usuario.
 */
@Component
public class RegistrarseUsuarioMapper {

    private final PasswordService passwordService;

    /**
     * Construye un nuevo RegistrarseUsuarioMapper con el servicio de contraseñas proporcionado.
     *
     * @param passwordService El servicio de contraseñas a utilizar.
     */
    public RegistrarseUsuarioMapper(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    /**
     * Convierte un DTO de solicitud de registro de persona natural a una entidad Usuario.
     *
     * @param datosPersonaNatural El DTO de solicitud.
     * @return La entidad Usuario.
     */
    public Usuario cNaturalDtoToUsuarioEntity(
        DatosPersonaNaturalRequestDTO datosPersonaNatural
    ) {
        Usuario usuario = new Usuario();
        usuario.setUsername(datosPersonaNatural.username());
        usuario.setPassword_hash(
            passwordService.hashPassword(datosPersonaNatural.plain_password())
        );
        usuario.setRol(Role.CLIENTE);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setActivo(true);
        return usuario;
    }

    /**
     * Convierte un DTO de solicitud de registro de empresa a una entidad Usuario.
     *
     * @param datosEmpresa El DTO de solicitud.
     * @return La entidad Usuario.
     */
    public Usuario empresaDtoToUsuarioEntity(
        DatosEmpresaRequestDTO datosEmpresa
    ) {
        Usuario usuario = new Usuario();
        usuario.setUsername(datosEmpresa.username());
        usuario.setPassword_hash(
            passwordService.hashPassword(datosEmpresa.plainPassword())
        );
        usuario.setRol(Role.CLIENTE);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setActivo(true);
        return usuario;
    }

    /**
     * Convierte un DTO de solicitud de registro de abogado a una entidad Usuario.
     *
     * @param datosAbogado El DTO de solicitud.
     * @return La entidad Usuario.
     */
    public Usuario abogadoDtoToUsuarioEntity(
        DatosAbogadoRequestDTO datosAbogado
    ) {
        Usuario usuario = new Usuario();
        usuario.setUsername(datosAbogado.username());
        usuario.setPassword_hash(
            passwordService.hashPassword(datosAbogado.plainPassword())
        );
        usuario.setRol(Role.ABOGADO);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setActivo(true);
        return usuario;
    }
}
