package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import org.springframework.data.domain.Page;

public interface IEmpresaService {

    Empresa crearEmpresa(Empresa empresa);

    Empresa obtenerPorId(Long id);

    Empresa obtenerPorRuc(String ruc);

    Page<Empresa> obtenerTodosPaginados(int pageNumber, int pageSize);

}
