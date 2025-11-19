package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import com.robinlb99.legalserviceportalapi.core.model.exception.EmpresaNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.EmpresaRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IEmpresaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementación del servicio de gestión de empresas.
 * Proporciona la lógica de negocio para las operaciones con empresas.
 */
@Service
public class EmpresaServiceImpl implements IEmpresaService {

    private final EmpresaRepository empresaRepository;

    /**
     * Construye un nuevo EmpresaServiceImpl con el repositorio de empresas proporcionado.
     *
     * @param empresaRepository El repositorio de empresas a utilizar.
     */
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    /**
     * Crea una nueva empresa.
     *
     * @param empresa La empresa a crear.
     * @return La empresa creada.
     */
    @Override
    @Transactional
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    /**
     * Obtiene una empresa por su ID.
     *
     * @param id El ID de la empresa a obtener.
     * @return La empresa encontrada.
     * @throws EmpresaNotFoundException Si no se encuentra ninguna empresa con el ID proporcionado.
     */
    @Override
    @Transactional(readOnly = true)
    public Empresa obtenerPorId(Long id) {
        return empresaRepository
                .findById(id)
                .orElseThrow(
                        () -> new EmpresaNotFoundException(
                                "Empresa con ID '" + id + "' no encontrada")
                );
    }

    /**
     * Obtiene una empresa por su RUC.
     *
     * @param ruc El RUC de la empresa a obtener.
     * @return La empresa encontrada.
     * @throws EmpresaNotFoundException Si no se encuentra ninguna empresa con el RUC proporcionado.
     */
    @Override
    @Transactional(readOnly = true)
    public Empresa obtenerPorRuc(String ruc) {
        return empresaRepository
                .findByRuc(ruc)
                .orElseThrow(
                        () -> new EmpresaNotFoundException(
                                "Empresa con RUC '" + ruc + "' + no encontrada")
                );
    }

    /**
     * Obtiene una lista paginada de empresas.
     *
     * @param pageNumber El número de página a obtener.
     * @param pageSize El tamaño de la página.
     * @return Una página de empresas.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Empresa> obtenerTodosPaginados(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.by("ruc").ascending()
        );
        return empresaRepository.findAll(pageable);
    }
}

