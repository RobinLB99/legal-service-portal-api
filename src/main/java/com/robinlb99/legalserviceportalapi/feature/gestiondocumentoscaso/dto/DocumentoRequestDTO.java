package com.robinlb99.legalserviceportalapi.feature.gestiondocumentoscaso.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

public record DocumentoRequestDTO(
    @NotNull(message = "El id del caso esta vacío") Long casoId,

    @NotNull(message = "Debe cargar un archivo") MultipartFile documento,

    @NotNull(message = "El nombre del documento es obligatorio") String nombre,

    @NotNull(message = "Debe especificar que tipo de documento es")
    String tipoDocumento,

    Map<String, Object> datosAdicionales
) {}
