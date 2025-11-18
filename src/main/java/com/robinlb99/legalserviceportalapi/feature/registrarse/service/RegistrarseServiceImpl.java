package com.robinlb99.legalserviceportalapi.feature.registrarse.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.PersonaNatural;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.service.PersonaNaturalServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioSerivceImpl;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarsePersonaNaturalMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseUsuarioMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract.IRegistrarseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class RegistrarseServiceImpl implements IRegistrarseService {

    private final RegistrarseUsuarioMapper usuarioMapper;
    private final RegistrarsePersonaNaturalMapper clienteNaturalMapper;
    private final UsuarioSerivceImpl usuarioSerivce;
    private final PersonaNaturalServiceImpl clienteNaturalService;

    public RegistrarseServiceImpl(RegistrarseUsuarioMapper usuarioMapper, RegistrarsePersonaNaturalMapper clienteNaturalMapper, UsuarioSerivceImpl usuarioSerivce, PersonaNaturalServiceImpl clienteNaturalService) {
        this.usuarioMapper = usuarioMapper;
        this.clienteNaturalMapper = clienteNaturalMapper;
        this.usuarioSerivce = usuarioSerivce;
        this.clienteNaturalService = clienteNaturalService;
    }

    @Override
    @Transactional
    public ResponseEntity<DatosPersonaNaturalResponseDTO> registrarsePersonaNatural(DatosPersonaNaturalRequestDTO datosCliente) {
//        log.info("Registro de usuario iniciado");
        Usuario usuario = usuarioMapper.cNaturalDtoToUsuarioEntity(datosCliente);
        usuario = usuarioSerivce.crearUsuario(usuario);

//        log.info("Registro de cliente iniciado");
        PersonaNatural clienteNatural = clienteNaturalMapper.cNaturalDtoToCNaturalEntity(datosCliente);
        clienteNatural.setUsuario(usuario);
        clienteNatural = clienteNaturalService.crearPersonaNatural(clienteNatural);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteNaturalMapper
                        .entityToDatosClienteNaturalResponseDTO(clienteNatural)
                );
    }

    @Override
    @Transactional
    public ResponseEntity<DatosEmpresaResponseDTO> registrarEmpresa(DatosEmpresaRequestDTO empresa) {
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<DatosAbogadoResponseDTO> registrarAbogado(DatosAbogadoRequestDTO abogado) {
        return null;
    }
}
