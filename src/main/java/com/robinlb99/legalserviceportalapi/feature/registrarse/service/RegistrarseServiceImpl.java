package com.robinlb99.legalserviceportalapi.feature.registrarse.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.CNatural;
import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.service.ClienteNaturalServiceImpl;
import com.robinlb99.legalserviceportalapi.core.service.UsuarioSerivceImpl;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseClienteNaturalMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.mapper.RegistrarseUsuarioMapper;
import com.robinlb99.legalserviceportalapi.feature.registrarse.dto.*;
import com.robinlb99.legalserviceportalapi.feature.registrarse.service.contract.IRegistrarseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrarseServiceImpl implements IRegistrarseService {

    private final RegistrarseUsuarioMapper usuarioMapper;
    private final RegistrarseClienteNaturalMapper clienteNaturalMapper;
    private final UsuarioSerivceImpl usuarioSerivce;
    private final ClienteNaturalServiceImpl clienteNaturalService;

    public RegistrarseServiceImpl(RegistrarseUsuarioMapper usuarioMapper, RegistrarseClienteNaturalMapper clienteNaturalMapper, UsuarioSerivceImpl usuarioSerivce, ClienteNaturalServiceImpl clienteNaturalService) {
        this.usuarioMapper = usuarioMapper;
        this.clienteNaturalMapper = clienteNaturalMapper;
        this.usuarioSerivce = usuarioSerivce;
        this.clienteNaturalService = clienteNaturalService;
    }

    @Override
    @Transactional
    public ResponseEntity<DatosClienteNaturalResponseDTO> registrarseClienteNatural(DatosClienteNaturalRequestDTO datosCliente) {
        Usuario usuario = usuarioMapper.cNaturalDtoToUsuarioEntity(datosCliente);
        usuario = usuarioSerivce.crearUsuario(usuario);

        CNatural clienteNatural = clienteNaturalMapper.cNaturalDtoToCNaturalEntity(datosCliente);
        clienteNatural.setUsuario(usuario);
        clienteNatural = clienteNaturalService.crearClienteNatural(clienteNatural);

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
