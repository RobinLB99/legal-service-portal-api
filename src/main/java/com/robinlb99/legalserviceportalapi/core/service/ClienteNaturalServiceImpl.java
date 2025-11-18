package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.CNatural;
import com.robinlb99.legalserviceportalapi.core.model.exception.ClienteNaturalNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.CNaturalRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IClienteNaturalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteNaturalServiceImpl implements IClienteNaturalService {

    private final CNaturalRepository clienteNaturalRepository;

    public  ClienteNaturalServiceImpl(CNaturalRepository clienteNaturalRepository) {
        this.clienteNaturalRepository = clienteNaturalRepository;
    }

    @Override
    @Transactional
    public CNatural crearClienteNatural(CNatural clienteNatural) {
        return clienteNaturalRepository.save(clienteNatural);
    }

    @Override
    @Transactional(readOnly = true)
    public CNatural obtenerClienteNaturalPorId(Long id) {
        return clienteNaturalRepository
                .findById(id)
                .orElseThrow(() ->
                        new ClienteNaturalNotFoundException(
                            "No existe el Cliente con ID '" + id + "'"
                )
        );
    }
}
