package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import com.robinlb99.legalserviceportalapi.core.repository.AbogadoRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IAbogadoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AbogadoServiceImpl implements IAbogadoService {

    private final AbogadoRepository abogadoRepository;

    public AbogadoServiceImpl(AbogadoRepository abogadoRepository) {
        this.abogadoRepository = abogadoRepository;
    }

    @Override
    public Abogado crearAbogado(Abogado abogado) {
        return abogadoRepository.save(abogado);
    }

    @Override
    public Abogado obtenerPorId(Long id) {
        return null;
    }

    @Override
    public Abogado obtenerPorCedula(String ruc) {
        return null;
    }

    @Override
    public Page<Abogado> obtenerTodosPaginados(String nombre) {
        return null;
    }
}
