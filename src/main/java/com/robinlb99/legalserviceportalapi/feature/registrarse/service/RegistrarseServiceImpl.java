package com.robinlb99.legalserviceportalapi.feature.registrarse.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.service.AbogadoServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.EmpresaServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.PersonaNaturalServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioServiceImpl;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseAbogadoMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseEmpresaMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarsePersonaNaturalMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseUsuarioMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract.IRegistrarseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de registro.
 * Proporciona la lógica de negocio para registrar nuevos usuarios.
 */
@Slf4j
@Service
public class RegistrarseServiceImpl implements IRegistrarseService {

    private final RegistrarseUsuarioMapper usuarioMapper;
    private final RegistrarsePersonaNaturalMapper clienteNaturalMapper;
    private final RegistrarseEmpresaMapper empresaMapper;
    private final RegistrarseAbogadoMapper abogadoMapper;
    private final UsuarioServiceImpl usuarioService;
    private final PersonaNaturalServiceImpl clienteNaturalService;
    private final EmpresaServiceImpl empresaService;
    private final AbogadoServiceImpl abogadoService;

    /**
     * Construye un nuevo RegistrarseServiceImpl con los mappers y servicios necesarios.
     *
     * @param usuarioMapper Mapper para el usuario.
     * @param clienteNaturalMapper Mapper para la persona natural.
     * @param empresaMapper Mapper para la empresa.
     * @param abogadoMapper Mapper para el abogado.
     * @param usuarioService Servicio para el usuario.
     * @param clienteNaturalService Servicio para la persona natural.
     * @param empresaService Servicio para la empresa.
     * @param abogadoService Servicio para el abogado.
     */
    public RegistrarseServiceImpl(
        RegistrarseUsuarioMapper usuarioMapper,
        RegistrarsePersonaNaturalMapper clienteNaturalMapper,
        RegistrarseEmpresaMapper empresaMapper,
        RegistrarseAbogadoMapper abogadoMapper,
        UsuarioServiceImpl usuarioService,
        PersonaNaturalServiceImpl clienteNaturalService,
        EmpresaServiceImpl empresaService,
        AbogadoServiceImpl abogadoService
    ) {
        this.usuarioMapper = usuarioMapper;
        this.clienteNaturalMapper = clienteNaturalMapper;
        this.empresaMapper = empresaMapper;
        this.abogadoMapper = abogadoMapper;
        this.usuarioService = usuarioService;
        this.clienteNaturalService = clienteNaturalService;
        this.empresaService = empresaService;
        this.abogadoService = abogadoService;
    }

    /**
     * Registra una nueva persona natural.
     *
     * @param datosCliente Los datos de la persona natural a registrar.
     * @return Un DTO con los datos de la persona natural registrada.
     */
    @Override
    @Transactional
    public DatosPersonaNaturalResponseDTO registrarsePersonaNatural(
        DatosPersonaNaturalRequestDTO datosCliente
    ) {
        Usuario usuario = usuarioMapper.cNaturalDtoToUsuarioEntity(
            datosCliente
        );
        usuario = usuarioService.crearUsuario(usuario);

        PersonaNatural clienteNatural =
            clienteNaturalMapper.cNaturalDtoToCNaturalEntity(datosCliente);
        clienteNatural.setUsuario(usuario);
        clienteNatural = clienteNaturalService.crearPersonaNatural(
            clienteNatural
        );

        return clienteNaturalMapper.entityToDatosClienteNaturalResponseDTO(
            clienteNatural
        );
    }

    /**
     * Registra una nueva empresa.
     *
     * @param empresaDto Los datos de la empresa a registrar.
     * @return Un DTO con los datos de la empresa registrada.
     */
    @Override
    @Transactional
    public DatosEmpresaResponseDTO registrarEmpresa(
        DatosEmpresaRequestDTO empresaDto
    ) {
        Usuario usuario = usuarioMapper.empresaDtoToUsuarioEntity(empresaDto);
        usuario = usuarioService.crearUsuario(usuario);

        Empresa empresa = empresaMapper.toEntity(empresaDto);
        empresa.setUsuario(usuario);
        empresa = empresaService.crearEmpresa(empresa);

        return empresaMapper.toDto(empresa);
    }

    /**
     * Registra un nuevo abogado.
     *
     * @param dto Los datos del abogado a registrar.
     * @return Un DTO con los datos del abogado registrado.
     */
    @Override
    @Transactional
    public DatosAbogadoResponseDTO registrarAbogado(
        DatosAbogadoRequestDTO dto
    ) {
        Usuario usuario = usuarioMapper.abogadoDtoToUsuarioEntity(dto);
        usuario = usuarioService.crearUsuario(usuario);

        Abogado abogado = abogadoMapper.toEntity(dto);
        abogado.setUsuario(usuario);
        abogado = abogadoService.crearAbogado(abogado);

        return abogadoMapper.toDTO(abogado);
    }
}
