package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.exception.PersonaNaturalNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.PersonaNaturalRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IPersonaNaturalService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementación del servicio de gestión de personas naturales.
 * Proporciona la lógica de negocio para las operaciones con personas naturales.
 */
@Service
public class PersonaNaturalServiceImpl implements IPersonaNaturalService {

    private final PersonaNaturalRepository personaNaturalRepository;

    /**
     * Construye un nuevo PersonaNaturalServiceImpl con el repositorio de personas naturales proporcionado.
     *
     * @param personaNaturalRepository El repositorio de personas naturales a utilizar.
     */
    public PersonaNaturalServiceImpl(PersonaNaturalRepository personaNaturalRepository) {
        this.personaNaturalRepository = personaNaturalRepository;
    }

    /**
     * Crea una nueva persona natural.
     *
     * @param personaNatural La persona natural a crear.
     * @return La persona natural creada.
     */
    @Override
    @Transactional
    public PersonaNatural crearPersonaNatural(PersonaNatural personaNatural) {
        return personaNaturalRepository.save(personaNatural);
    }

    /**
     * Obtiene una persona natural por su ID.
     *
     * @param id El ID de la persona natural a obtener.
     * @return La persona natural encontrada.
     * @throws PersonaNaturalNotFoundException Si no se encuentra ninguna persona natural con el ID proporcionado.
     */
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

    /**
     * Obtiene una persona natural por su cédula.
     *
     * @param ruc La cédula de la persona natural a obtener.
     * @return La persona natural encontrada.
     */
    @Override
    public PersonaNatural obtenerPersonaNaturalPorCedula(String ruc) {
        return null;
    }

    /**
     * Obtiene una lista paginada de personas naturales.
     *
     * @param nombre El nombre a utilizar como filtro (actualmente no implementado).
     * @return Una página de personas naturales.
     */
    @Override
    public Page<PersonaNatural> obtenerTodosPaginados(String nombre) {
        return null;
    }
}

