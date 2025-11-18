package com.robinlb99.legalserviceportalapi.feature.registrarse.mapper;

import com.robinlb99.legalserviceportalapi.common.util.PasswordService;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.enums.Role;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosAbogadoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosPersonaNaturalRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RegistrarseUsuarioMapper {

    private final PasswordService passwordService;

    public RegistrarseUsuarioMapper(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    public Usuario cNaturalDtoToUsuarioEntity(DatosPersonaNaturalRequestDTO datosPersonaNatural) {
        Usuario usuario = new Usuario();
        usuario.setUsername(datosPersonaNatural.username());
        usuario.setPassword_hash(
                passwordService.hashPassword(
                        datosPersonaNatural.plain_password()
                )
        );
        usuario.setRol(Role.CLIENTE);
        usuario.setFecha_registro(LocalDateTime.now());
        usuario.setActivo(true);
        return usuario;
    }

    public Usuario abogadoDtoToUsuarioEntity(DatosAbogadoRequestDTO datosAbogado) {
        Usuario usuario = new Usuario();
        usuario.setUsername(datosAbogado.ussername());
        usuario.setRol(Role.ABOGADO);
        return usuario;
    }



}
