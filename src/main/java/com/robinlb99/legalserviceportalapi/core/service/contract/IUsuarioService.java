package com.robinlb99.legalserviceportalapi.core.service.contract;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;


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
     */
    Usuario buscarUsuarioPorId(Long idUsuario);

    /**
     * Elimina un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a eliminar.
     */
    void eliminarUsuarioPorId(Long idUsuario);

    /**
     * Actualiza la contraseña codificada de un usuario.
     *
     * @param idUsuario El ID del usuario.
     * @param nuevaContrasenaCodificada La nueva contraseña codificada.
     */
    void actualizarContrasenaCodificada(Long idUsuario, String nuevaContrasenaCodificada);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario a buscar.
     * @return El usuario encontrado.
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

