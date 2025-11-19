package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import com.robinlb99.legalserviceportalapi.core.repository.AbogadoRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IAbogadoService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de gestión de abogados.
 * Proporciona la lógica de negocio para las operaciones con abogados.
 */
@Service
public class AbogadoServiceImpl implements IAbogadoService {

    private final AbogadoRepository abogadoRepository;

    /**
     * Construye un nuevo AbogadoServiceImpl con el repositorio de abogados proporcionado.
     *
     * @param abogadoRepository El repositorio de abogados a utilizar.
     */
    public AbogadoServiceImpl(AbogadoRepository abogadoRepository) {
        this.abogadoRepository = abogadoRepository;
    }

    /**
     * Crea un nuevo abogado.
     *
     * @param abogado El abogado a crear.
     * @return El abogado creado.
     */
    @Override
    public Abogado crearAbogado(Abogado abogado) {
        return abogadoRepository.save(abogado);
    }

    /**
     * Obtiene un abogado por su ID.
     *
     * @param id El ID del abogado a obtener.
     * @return El abogado encontrado.
     */
    @Override
    public Abogado obtenerPorId(Long id) {
        return null;
    }

    /**
     * Obtiene un abogado por su cédula.
     *
     * @param ruc La cédula del abogado a obtener.
     * @return El abogado encontrado.
     */
    @Override
    public Abogado obtenerPorCedula(String ruc) {
        return null;
    }

    /**
     * Obtiene una lista paginada de abogados.
     *
     * @param nombre El nombre a utilizar como filtro (actualmente no implementado).
     * @return Una página de abogados.
     */
    @Override
    public Page<Abogado> obtenerTodosPaginados(String nombre) {
        return null;
    }
}
