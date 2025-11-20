package com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.service.contract;

import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminPasswordDTO;
import com.robinlb99.legalserviceportalapi.feature.crearusuarioadmin.dto.UsuarioAdminResponseDTO;

public interface ICrearUsuarioAdminService {
    UsuarioAdminResponseDTO crearUsuarioAdmin(UsuarioAdminPasswordDTO adminPasswordDTO);
}
