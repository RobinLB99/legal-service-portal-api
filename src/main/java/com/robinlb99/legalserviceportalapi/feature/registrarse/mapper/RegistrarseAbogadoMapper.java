package com.robinlb99.legalserviceportalapi.feature.registrarse.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import com.robinlb99.legalserviceportalapi.core.model.valueobject.DatosPersonales;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosAbogadoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosAbogadoResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Mapper para el registro de un abogado.
 * Convierte DTOs a entidades y viceversa.
 */
@Component
public class RegistrarseAbogadoMapper {

    /**
     * Convierte un DTO de solicitud de registro de abogado a una entidad Abogado.
     *
     * @param datosAbogado El DTO de solicitud.
     * @return La entidad Abogado.
     */
    public Abogado toEntity(DatosAbogadoRequestDTO datosAbogado) {
        Abogado abogado = new Abogado();
        abogado.setDatosPersonales(new DatosPersonales());
        abogado.getDatosPersonales().setNombres(datosAbogado.nombres());
        abogado.getDatosPersonales().setApellidos(datosAbogado.apellidos());
        abogado
            .getDatosPersonales()
            .setNumero_cedula(datosAbogado.numeroCedula());
        abogado
            .getDatosPersonales()
            .setCorreo_electronico(datosAbogado.correoElectronico());
        abogado
            .getDatosPersonales()
            .setNumero_telefono(datosAbogado.numeroTelefono());
        abogado.setEspecialidad(datosAbogado.especialidad());
        abogado.setLicencia(datosAbogado.licencia());
        return abogado;
    }

    /**
     * Convierte una entidad Abogado a un DTO de respuesta de registro de abogado.
     *
     * @param abogado La entidad Abogado.
     * @return El DTO de respuesta.
     */
    public DatosAbogadoResponseDTO toDTO(Abogado abogado) {
        return new DatosAbogadoResponseDTO(
            abogado.getId(),
            abogado.getUsuario().getUsername(),
            abogado.getDatosPersonales().getNombres(),
            abogado.getDatosPersonales().getApellidos(),
            abogado.getEspecialidad(),
            abogado.getLicencia()
        );
    }
}
