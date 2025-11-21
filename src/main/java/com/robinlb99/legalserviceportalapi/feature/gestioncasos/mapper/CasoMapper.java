package com.robinlb99.legalserviceportalapi.feature.gestioncasos.mapper;

import com.robinlb99.legalserviceportalapi.core.model.entity.Caso;
import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCaso;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto.CasoRequestDTO;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.dto.CasoResponseDTO;
import com.robinlb99.legalserviceportalapi.feature.gestioncasos.helper.CasoHelper;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

/**
 * Mapper para la gestión de casos.
 */
@Component
public class CasoMapper {

    private final CasoHelper casoHelper;

    public CasoMapper(CasoHelper casoHelper) {
        this.casoHelper = casoHelper;
    }

    /**
     * Convierte un DTO de creación de caso a una entidad de caso.
     *
     * @param casoRequestDTO DTO de creación de caso.
     * @return Entidad de caso.
     */
    public Caso toEntity(CasoRequestDTO casoRequestDTO) {
        TipoCaso tipoCaso = casoHelper.obtenerTipoCaso(
            casoRequestDTO.tipoCaso()
        );

        Caso caso = new Caso();
        caso.setTitulo(casoRequestDTO.titulo());
        caso.setDescripcion(casoRequestDTO.descripcion());
        caso.setTipo_caso(tipoCaso);
        caso.setEstado_caso(EstadoCaso.REVISION);
        caso.setFecha_creacion(LocalDate.now());

        return caso;
    }

    /**
     * Convierte una entidad de caso a un DTO de respuesta de caso.
     *
     * @param caso Entidad de caso.
     * @return DTO de respuesta de caso.
     */
    public CasoResponseDTO toDTO(Caso caso) {
        return new CasoResponseDTO(
            caso.getId(),
            caso.getTitulo(),
            caso.getDescripcion(),
            caso.getTipo_caso().name(),
            caso.getFecha_creacion(),
            caso.getFecha_actualizacion(),
            caso.getFecha_cierre(),
            caso.getAbogado().getId(),
            caso.getCliente().getId()
        );
    }
}
