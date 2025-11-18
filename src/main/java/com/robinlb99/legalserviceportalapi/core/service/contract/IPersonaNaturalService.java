package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import org.springframework.data.domain.Page;

public interface IPersonaNaturalService {
    PersonaNatural crearPersonaNatural(PersonaNatural personaNatural);
    PersonaNatural obtenerPersonaNaturalPorId(Long id);

    PersonaNatural obtenerPersonaNaturalPorCedula(String ruc);

    Page<PersonaNatural> obtenerTodosPaginados(String nombre);
}
