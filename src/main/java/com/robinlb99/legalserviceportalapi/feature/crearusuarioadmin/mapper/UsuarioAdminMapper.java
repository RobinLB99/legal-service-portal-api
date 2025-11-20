package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAdminMapper {
    public UsuarioAdminResponseDTO toDTO(Usuario usuario) {
        return new UsuarioAdminResponseDTO(
            usuario.getId(),
            usuario.getUsername(),
            usuario.isActivo()
        );
    }
}
