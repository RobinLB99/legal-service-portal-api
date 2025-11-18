package com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract;

import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import org.springframework.http.ResponseEntity;

public interface IRegistrarseService {
    ResponseEntity<DatosPersonaNaturalResponseDTO> registrarsePersonaNatural(DatosPersonaNaturalRequestDTO cliente);

    ResponseEntity<DatosEmpresaResponseDTO> registrarEmpresa(DatosEmpresaRequestDTO empresa);

    ResponseEntity<DatosAbogadoResponseDTO> registrarAbogado(DatosAbogadoRequestDTO abogado);
}
