package com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract;

import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import org.springframework.http.ResponseEntity;

/**
 * Contrato para el servicio de registro.
 * Define los métodos que deben ser implementados por cualquier servicio
 * que gestione el registro de nuevos usuarios.
 */
public interface IRegistrarseService {
    /**
     * Registra una nueva persona natural.
     *
     * @param cliente Los datos de la persona natural a registrar.
     * @return Un DTO con los datos de la persona natural registrada.
     */
    DatosPersonaNaturalResponseDTO registrarsePersonaNatural(
        DatosPersonaNaturalRequestDTO cliente
    );

    /**
     * Registra una nueva empresa.
     *
     * @param empresa Los datos de la empresa a registrar.
     * @return Un DTO con los datos de la empresa registrada.
     */
    DatosEmpresaResponseDTO registrarEmpresa(DatosEmpresaRequestDTO empresa);

    /**
     * Registra un nuevo abogado.
     *
     * @param abogado Los datos del abogado a registrar.
     * @return Un DTO con los datos del abogado registrado.
     */
    DatosAbogadoResponseDTO registrarAbogado(DatosAbogadoRequestDTO abogado);
}
