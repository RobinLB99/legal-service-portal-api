package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import org.springframework.data.domain.Page;


/**
 * Contrato para el servicio de gestión de empresas.
 * Define los métodos que deben ser implementados por cualquier servicio
 * que gestione las operaciones de negocio para las empresas.
 */
public interface IEmpresaService {

    /**
     * Crea una nueva empresa.
     *
     * @param empresa La empresa a crear.
     * @return La empresa creada.
     */
    Empresa crearEmpresa(Empresa empresa);

    /**
     * Obtiene una empresa por su ID.
     *
     * @param id El ID de la empresa a obtener.
     * @return La empresa encontrada.
     */
    Empresa obtenerPorId(Long id);

    /**
     * Obtiene una empresa por su RUC.
     *
     * @param ruc El RUC de la empresa a obtener.
     * @return La empresa encontrada.
     */
    Empresa obtenerPorRuc(String ruc);

    /**
     * Obtiene una lista paginada de empresas.
     *
     * @param pageNumber El número de página a obtener.
     * @param pageSize El tamaño de la página.
     * @return Una página de empresas.
     */
    Page<Empresa> obtenerTodosPaginados(int pageNumber, int pageSize);

}

