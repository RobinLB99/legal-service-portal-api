package com.robinlb99.legalserviceportalapi.core.mapper;

import com.robinlb99.legalserviceportalapi.core.domain.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.dto.UsuarioRequestDTO;
import com.robinlb99.legalserviceportalapi.core.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDTO.username());
        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getUsername(),
            usuario.getRol(),
            usuario.isActivo()
        );
    }
}
