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

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    @Transactional
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

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
