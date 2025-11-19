package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import org.springframework.data.domain.Page;


/**
 * Contrato para el servicio de gestión de abogados.
 * Define los métodos que deben ser implementados por cualquier servicio
 * que gestione las operaciones de negocio para los abogados.
 */
public interface IAbogadoService {

    /**
     * Crea un nuevo abogado.
     *
     * @param abogado El abogado a crear.
     * @return El abogado creado.
     */
    Abogado crearAbogado(Abogado abogado);

    /**
     * Obtiene un abogado por su ID.
     *
     * @param id El ID del abogado a obtener.
     * @return El abogado encontrado.
     */
    Abogado obtenerPorId(Long id);

    /**
     * Obtiene un abogado por su cédula.
     *
     * @param ruc La cédula del abogado a obtener.
     * @return El abogado encontrado.
     */
    Abogado obtenerPorCedula(String ruc);

    /**
     * Obtiene una lista paginada de abogados.
     *
     * @param nombre El nombre a utilizar como filtro (actualmente no implementado).
     * @return Una página de abogados.
     */
    Page<Abogado> obtenerTodosPaginados(String nombre);
}

