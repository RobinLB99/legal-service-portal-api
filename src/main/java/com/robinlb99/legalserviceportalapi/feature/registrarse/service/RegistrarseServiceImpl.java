package com.robinlb99.legalserviceportalapi.feature.registrarse.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Empresa;
import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.service.EmpresaServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.PersonaNaturalServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioSerivceImpl;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
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
    private final UsuarioSerivceImpl usuarioSerivce;
    private final PersonaNaturalServiceImpl clienteNaturalService;
    private final EmpresaServiceImpl empresaService;

    public RegistrarseServiceImpl(
        RegistrarseUsuarioMapper usuarioMapper,
        RegistrarsePersonaNaturalMapper clienteNaturalMapper,
        RegistrarseEmpresaMapper empresaMapper,
        UsuarioSerivceImpl usuarioSerivce,
        PersonaNaturalServiceImpl clienteNaturalService,
        EmpresaServiceImpl empresaService
    ) {
        this.usuarioMapper = usuarioMapper;
        this.clienteNaturalMapper = clienteNaturalMapper;
        this.empresaMapper = empresaMapper;
        this.usuarioSerivce = usuarioSerivce;
        this.clienteNaturalService = clienteNaturalService;
        this.empresaService = empresaService;
    }

    @Override
    @Transactional
    public DatosPersonaNaturalResponseDTO registrarsePersonaNatural(DatosPersonaNaturalRequestDTO datosCliente) {
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

        return new DatosPersonaNaturalResponseDTO(
                clienteNatural.getId(),
                clienteNatural.getUsuario().getUsername(),
                clienteNatural.getDatosPersonales().getNombres(),
                clienteNatural.getDatosPersonales().getApellidos(),
                clienteNatural.getGenero().name(),
                clienteNatural.getDatosPersonales().getCorreo_electronico()
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

        return new DatosEmpresaResponseDTO(
            empresa.getId(),
            empresa.getUsuario().getUsername(),
            empresa.getRazon_social(),
            empresa.getRepresentante_legal()
        );
    }

    @Override
    @Transactional
    public DatosAbogadoResponseDTO registrarAbogado(
        DatosAbogadoRequestDTO abogado
    ) {
        return null;
    }
}
