package com.robinlb99.legalserviceportalapi.core.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
		@NotBlank(message = "El nombre de usuario es obligatorio.")
		String username,
		@NotBlank(message = "La contraseña es requerida.")
		String password,
		@NotBlank(message = "El rol de usuario es requerido.")
		String rol
) {}
