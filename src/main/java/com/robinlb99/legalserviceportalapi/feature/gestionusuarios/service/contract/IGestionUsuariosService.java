package com.robinlb99.legalserviceportalapi.feature.gestionusuarios.service.contract;

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
     * @param id El ID del usuario a actualizar.
     * @param estadoDTO DTO con el nuevo estado de habilitación.
     */
    void actualizarEstadoUsuario(Long id, UsuarioEstadoPatchDTO estadoDTO);

    /**
     * Actualiza el nombre de usuario de un usuario.
     *
     * @param id El ID del usuario a actualizar.
     * @param usernameDTO DTO con el nuevo nombre de usuario.
     */
    void actualizarUsernameUsuario(
        Long id,
        UsuarioUsernamePatchDTO usernameDTO
    );

    /**
     * Actualiza la contraseña de un usuario.
     *
     * @param id El ID del usuario a actualizar.
     * @param passwordDTO DTO con la nueva contraseña.
     */
    void actualizarPasswordUsuario(
        Long id,
        UsuarioPasswordPatchDTO passwordDTO
    );
}
