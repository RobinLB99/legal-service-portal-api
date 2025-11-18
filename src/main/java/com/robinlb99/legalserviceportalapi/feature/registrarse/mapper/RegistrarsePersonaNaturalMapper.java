package com.robinlb99.legalserviceportalapi.feature.registrarse.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCivil;
import com.robinlb99.legalserviceportalapi.core.model.enums.Genero;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;
import com.robinlb99.legalserviceportalapi.core.model.exception.IllegalEstadoCivilException;
import com.robinlb99.legalserviceportalapi.core.model.exception.IllegalGeneroException;
import com.robinlb99.legalserviceportalapi.core.model.valueobject.DatosPersonales;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosPersonaNaturalRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.DatosPersonaNaturalResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class RegistrarsePersonaNaturalMapper {
    public PersonaNatural cNaturalDtoToCNaturalEntity(DatosPersonaNaturalRequestDTO datosCliente) {
        DatosPersonales datosPersonales = new DatosPersonales();

        Genero genero = switch (datosCliente.genero()) {
            case "MASCULINO" -> Genero.MASCULINO;
            case "FEMENINO" -> Genero.FEMENINO;
            default -> throw new IllegalGeneroException("El genero ingresado no es valido");
        };

        EstadoCivil estadoCivil = switch (datosCliente.estadoCivil()) {
            case "SOLTERO" -> EstadoCivil.SOLTERO;
            case "CASADO" -> EstadoCivil.CASADO;
            case "DIVORCIADO" -> EstadoCivil.DIVORCIADO;
            case "VIUDO" -> EstadoCivil.VIUDO;
            default -> throw new IllegalEstadoCivilException("El estado civil ingresado no es valido");
        };

        LocalDate fechaNacimiento = LocalDate.parse(datosCliente.fechaNacimiento());

        PersonaNatural clienteNatural = new PersonaNatural();
        clienteNatural.setDatosPersonales(datosPersonales);
        clienteNatural.getDatosPersonales().setNombres(datosCliente.nombres());
        clienteNatural.getDatosPersonales().setApellidos(datosCliente.apellidos());
        clienteNatural.getDatosPersonales().setNumero_cedula(datosCliente.numeroCedula());
        clienteNatural.getDatosPersonales().setCorreo_electronico(datosCliente.correoElectronico());
        clienteNatural.getDatosPersonales().setNumero_telefono(datosCliente.numeroTelefono());
        clienteNatural.setTipo_cliente(TipoCliente.NATURAL);
        clienteNatural.setGenero(genero);
        clienteNatural.setEstado_civil(estadoCivil);
        clienteNatural.setFecha_nacimiento(fechaNacimiento);
        clienteNatural.setDireccion_domicilio(datosCliente.direccionDomicilio());
        return clienteNatural;
    }

    public DatosPersonaNaturalResponseDTO entityToDatosClienteNaturalResponseDTO(PersonaNatural clienteNatural) {
        return new DatosPersonaNaturalResponseDTO(
                clienteNatural.getId(),
                clienteNatural.getUsuario().getUsername(),
                clienteNatural.getDatosPersonales().getNombres(),
                clienteNatural.getDatosPersonales().getApellidos(),
                clienteNatural.getGenero().name(),
                clienteNatural.getDatosPersonales().getCorreo_electronico()
        );
    }
}
