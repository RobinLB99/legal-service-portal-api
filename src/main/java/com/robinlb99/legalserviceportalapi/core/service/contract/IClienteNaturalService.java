package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.CNatural;

public interface IClienteNaturalService {
    CNatural crearClienteNatural(CNatural clienteNatural);
    CNatural obtenerClienteNaturalPorId(Long id);
}
