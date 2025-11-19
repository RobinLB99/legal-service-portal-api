package com.robinlb99.legalserviceportalapi.feature.registrarse.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosEmpresaRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosEmpresaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RegistrarseEmpresaMapper {

    public Empresa toEntity(DatosEmpresaRequestDTO empresaDto) {
        Empresa empresa = new Empresa();
        empresa.setTipo_cliente(TipoCliente.JURIDICO);
        empresa.setRuc(empresaDto.ruc());
        empresa.setCorreo_institucional(empresaDto.correoInstitucional());
        empresa.setRazon_social(empresaDto.razonSocial());
        empresa.setDireccion_institucional(empresaDto.direccionInstitucion());
        empresa.setRepresentante_legal(empresaDto.representanteLegal());
        empresa.setTelefono_institucional(empresaDto.telefonoInstitucional());
        return empresa;
    }

    public DatosEmpresaResponseDTO toDto(Empresa empresa) {
        return new DatosEmpresaResponseDTO(
                empresa.getId(),
                empresa.getUsuario().getUsername(),
                empresa.getRazon_social(),
                empresa.getRepresentante_legal()
        );
    }

}
