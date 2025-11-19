package com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract;

import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import org.springframework.http.ResponseEntity;

public interface IRegistrarseService {
    DatosPersonaNaturalResponseDTO registrarsePersonaNatural(DatosPersonaNaturalRequestDTO cliente);

    DatosEmpresaResponseDTO registrarEmpresa(DatosEmpresaRequestDTO empresa);

    DatosAbogadoResponseDTO registrarAbogado(DatosAbogadoRequestDTO abogado);
}
