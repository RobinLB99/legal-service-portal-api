package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.exception.SamePasswordException;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioEstadoPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioPasswordPatchDTO;
import com.robinlb99.legalserviceportalapi.feature.gestionusuarios.dto.UsuarioUsernamePatchDTO;

/**
 * Interfaz que define las operaciones de gestión de usuarios.
 */
public interface IGestionUsuariosService {
    /**
     * Actualiza el estado de habilitación de un usuario.
     *
     * @param estadoDTO DTO con el nuevo estado de habilitación.
     * @throws UsuarioNotFoundException si no se encuentra el usuario.
     */
    void actualizarEstadoUsuario(UsuarioEstadoPatchDTO estadoDTO);

    /**
     * Actualiza el nombre de usuario de un usuario.
     *
     * @param usernameDTO DTO con el nombre de usuario actual y el nuevo nombre de usuario.
     * @throws UsuarioNotFoundException si no se encuentra el usuario.
     */
    void actualizarUsernameUsuario(UsuarioUsernamePatchDTO usernameDTO);

    /**
     * Actualiza la contraseña de un usuario.
     *
     * @param passwordDTO DTO con la nueva contraseña.
     * @throws UsuarioNotFoundException si no se encuentra el usuario.
     * @throws SamePasswordException si la nueva contraseña es igual a la actual.
     */
    void actualizarPasswordUsuario(UsuarioPasswordPatchDTO passwordDTO);
}
