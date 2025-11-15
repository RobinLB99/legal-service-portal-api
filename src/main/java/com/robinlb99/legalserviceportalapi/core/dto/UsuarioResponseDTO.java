package com.robinlb99.legalserviceportalapi.core.dto;

import com.robinlb99.legalserviceportalapi.core.domain.enums.Role;

public record UsuarioResponseDTO(
    Long id,
    String username,
    Role rol,
    boolean activo
) {}
