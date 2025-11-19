package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import org.springframework.data.domain.Page;

public interface IAbogadoService {
    Abogado crearAbogado(Abogado abogado);

    Abogado obtenerPorId(Long id);

    Abogado obtenerPorCedula(String ruc);

    Page<Abogado> obtenerTodosPaginados(String nombre);
}
