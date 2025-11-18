package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.exception.PersonaNaturalNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.PersonaNaturalRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IPersonaNaturalService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaNaturalServiceImpl implements IPersonaNaturalService {

    private final PersonaNaturalRepository personaNaturalRepository;

    public PersonaNaturalServiceImpl(PersonaNaturalRepository personaNaturalRepository) {
        this.personaNaturalRepository = personaNaturalRepository;
    }

    @Override
    @Transactional
    public PersonaNatural crearPersonaNatural(PersonaNatural personaNatural) {
        return personaNaturalRepository.save(personaNatural);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaNatural obtenerPersonaNaturalPorId(Long id) {
        return personaNaturalRepository
                .findById(id)
                .orElseThrow(() ->
                        new PersonaNaturalNotFoundException(
                            "No existe el Cliente con ID '" + id + "'"
                )
        );
    }

    @Override
    public PersonaNatural obtenerPersonaNaturalPorCedula(String ruc) {
        return null;
    }

    @Override
    public Page<PersonaNatural> obtenerTodosPaginados(String nombre) {
        return null;
    }
}
