package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import org.springframework.data.domain.Page;


/**
 * Contrato para el servicio de gestión de personas naturales.
 * Define los métodos que deben ser implementados por cualquier servicio
 * que gestione las operaciones de negocio para las personas naturales.
 */
public interface IPersonaNaturalService {

    /**
     * Crea una nueva persona natural.
     *
     * @param personaNatural La persona natural a crear.
     * @return La persona natural creada.
     */
    PersonaNatural crearPersonaNatural(PersonaNatural personaNatural);

    /**
     * Obtiene una persona natural por su ID.
     *
     * @param id El ID de la persona natural a obtener.
     * @return La persona natural encontrada.
     */
    PersonaNatural obtenerPersonaNaturalPorId(Long id);

    /**
     * Obtiene una persona natural por su cédula.
     *
     * @param ruc La cédula de la persona natural a obtener.
     * @return La persona natural encontrada.
     */
    PersonaNatural obtenerPersonaNaturalPorCedula(String ruc);

    /**
     * Obtiene una lista paginada de personas naturales.
     *
     * @param nombre El nombre a utilizar como filtro (actualmente no implementado).
     * @return Una página de personas naturales.
     */
    Page<PersonaNatural> obtenerTodosPaginados(String nombre);
}

