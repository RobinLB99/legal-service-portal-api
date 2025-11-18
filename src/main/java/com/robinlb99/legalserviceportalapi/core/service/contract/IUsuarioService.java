package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;

public interface IUsuarioService {
    Usuario crearUsuario(Usuario usuario);

    Usuario buscarUsuarioPorId(Long idUsuario);

    void eliminarUsuarioPorId(Long idUsuario);

    void actualizarContrasenaCodificada(Long idUsuario, String nuevaContrasenaCodificada);

    Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);

    void deshabilitarUsuarioPorId(Long idUsuario);

    void deshabilitarUsuarioPorNombreUsuario(String nombreUsuario);

    void habilitarUsuarioPorId(Long idUsuario);

    void habilitarUsuarioPorNombreUsuario(String nombreUsuario);

    boolean existeUsuarioPorNombreUsuario(String nombreUsuario);
}
