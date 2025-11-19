package com.robinlb99.legalserviceportalapi.feature.registrarse.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Abogado;
import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.service.AbogadoServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.EmpresaServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.PersonaNaturalServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioSerivceImpl;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseAbogadoMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseEmpresaMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarsePersonaNaturalMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseUsuarioMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract.IRegistrarseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RegistrarseServiceImpl implements IRegistrarseService {

    private final RegistrarseUsuarioMapper usuarioMapper;
    private final RegistrarsePersonaNaturalMapper clienteNaturalMapper;
    private final RegistrarseEmpresaMapper empresaMapper;
    private final RegistrarseAbogadoMapper abogadoMapper;
    private final UsuarioSerivceImpl usuarioSerivce;
    private final PersonaNaturalServiceImpl clienteNaturalService;
    private final EmpresaServiceImpl empresaService;
    private final AbogadoServiceImpl abogadoService;

    public RegistrarseServiceImpl(
        RegistrarseUsuarioMapper usuarioMapper,
        RegistrarsePersonaNaturalMapper clienteNaturalMapper,
        RegistrarseEmpresaMapper empresaMapper,
        RegistrarseAbogadoMapper abogadoMapper,
        UsuarioSerivceImpl usuarioSerivce,
        PersonaNaturalServiceImpl clienteNaturalService,
        EmpresaServiceImpl empresaService,
        AbogadoServiceImpl abogadoService
    ) {
        this.usuarioMapper = usuarioMapper;
        this.clienteNaturalMapper = clienteNaturalMapper;
        this.empresaMapper = empresaMapper;
        this.abogadoMapper = abogadoMapper;
        this.usuarioSerivce = usuarioSerivce;
        this.clienteNaturalService = clienteNaturalService;
        this.empresaService = empresaService;
        this.abogadoService = abogadoService;
    }

    @Override
    @Transactional
    public DatosPersonaNaturalResponseDTO registrarsePersonaNatural(
        DatosPersonaNaturalRequestDTO datosCliente
    ) {
        Usuario usuario = usuarioMapper.cNaturalDtoToUsuarioEntity(
            datosCliente
        );
        usuario = usuarioSerivce.crearUsuario(usuario);

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

    @Override
    @Transactional
    public DatosEmpresaResponseDTO registrarEmpresa(
        DatosEmpresaRequestDTO empresaDto
    ) {
        Usuario usuario = usuarioMapper.empresaDtoToUsuarioEntity(empresaDto);
        usuario = usuarioSerivce.crearUsuario(usuario);

        Empresa empresa = empresaMapper.toEntity(empresaDto);
        empresa.setUsuario(usuario);
        empresa = empresaService.crearEmpresa(empresa);

        return empresaMapper.toDto(empresa);
    }

    @Override
    @Transactional
    public DatosAbogadoResponseDTO registrarAbogado(
        DatosAbogadoRequestDTO dto
    ) {
        Usuario usuario = usuarioMapper.abogadoDtoToUsuarioEntity(dto);
        usuario = usuarioSerivce.crearUsuario(usuario);

        Abogado abogado = abogadoMapper.toEntity(dto);
        abogado.setUsuario(usuario);
        abogado = abogadoService.crearAbogado(abogado);

        return abogadoMapper.toDTO(abogado);
    }
}
