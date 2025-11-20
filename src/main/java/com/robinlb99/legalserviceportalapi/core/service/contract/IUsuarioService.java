package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;


/**
 * Contrato para el servicio de gestión de usuarios.
 * Define los métodos que deben ser implementados por cualquier servicio
 * que gestione las operaciones de negocio para los usuarios.
 */
public interface IUsuarioService {

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario El usuario a crear.
     * @return El usuario creado.
     */
    Usuario crearUsuario(Usuario usuario);

    /**
     * Busca un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a buscar.
     * @return El usuario encontrado.
     * @throws UsuarioNotFoundException si no se encuentra ningún usuario con el ID proporcionado.
     */
    Usuario buscarUsuarioPorId(Long idUsuario);


    /**
     * Actualiza la contraseña codificada de un usuario.
     *
     * @param idUsuario El ID del usuario.
     * @param nuevaContrasenaCodificada La nueva contraseña codificada.
     */
    void actualizarContrasenaCodificada(Long idUsuario, String nuevaContrasenaCodificada);

    /**
     * Actualiza el nombre de usuario de un usuario.
     *
     * @param id El ID del usuario.
     * @param nuevoUsername El nuevo nombre de usuario.
     */
    void actualizarNombreUsuario(Long id, String nuevoUsername);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario a buscar.
     * @return El usuario encontrado.
     * @throws UsuarioNotFoundException si no se encuentra ningún usuario con el nombre de usuario proporcionado.
     */
    Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);

    /**
     * Deshabilita un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a deshabilitar.
     */
    void deshabilitarUsuarioPorId(Long idUsuario);

    /**
     * Deshabilita un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario del usuario a deshabilitar.
     */
    void deshabilitarUsuarioPorNombreUsuario(String nombreUsuario);

    /**
     * Habilita un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a habilitar.
     */
    void habilitarUsuarioPorId(Long idUsuario);

    /**
     * Habilita un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario del usuario a habilitar.
     */
    void habilitarUsuarioPorNombreUsuario(String nombreUsuario);

    /**
     * Comprueba si existe un usuario con el nombre de usuario proporcionado.
     *
     * @param nombreUsuario El nombre de usuario a comprobar.
     * @return true si existe un usuario con el nombre de usuario proporcionado, false en caso contrario.
     */
    boolean existeUsuarioPorNombreUsuario(String nombreUsuario);
}

