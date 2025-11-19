package com.robinlb99.legalserviceportalapi.core.service;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import com.robinlb99.legalserviceportalapi.core.model.exception.UsuarioNotFoundException;
import com.robinlb99.legalserviceportalapi.core.repository.UsuarioRepository;
import com.robinlb99.legalserviceportalapi.core.service.contract.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de gestión de usuarios.
 * Proporciona la lógica de negocio para las operaciones con usuarios.
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Construye un nuevo UsuarioServiceImpl con el repositorio de usuarios proporcionado.
     *
     * @param usuarioRepository El repositorio de usuarios a utilizar.
     */
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Crea un nuevo usuario.
     *
     * @param usuario El usuario a crear.
     * @return El usuario creado.
     */
    @Override
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a buscar.
     * @return El usuario encontrado.
     * @throws UsuarioNotFoundException Si no se encuentra ningún usuario con el ID proporcionado.
     */
    @Override
    @Transactional
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(
                () -> new UsuarioNotFoundException("Usuario con ID '" +
                        idUsuario + "' no encontrado")
        );
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a eliminar.
     */
    @Override
    @Transactional
    public void eliminarUsuarioPorId(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    /**
     * Actualiza la contraseña codificada de un usuario.
     *
     * @param idUsuario El ID del usuario.
     * @param nuevaContrasenaCodificada La nueva contraseña codificada.
     */
    @Override
    @Transactional
    public void actualizarContrasenaCodificada(Long idUsuario, String nuevaContrasenaCodificada) {
        usuarioRepository.updatePasswordEncode(idUsuario, nuevaContrasenaCodificada);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario a buscar.
     * @return El usuario encontrado.
     * @throws UsuarioNotFoundException Si no se encuentra ningún usuario con el nombre de usuario proporcionado.
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByUsername(nombreUsuario).orElseThrow(
                () -> new UsuarioNotFoundException(
                        "Usuario '" + nombreUsuario + "' no encontrado"
                )
        );
    }

    /**
     * Deshabilita un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a deshabilitar.
     */
    @Override
    @Transactional
    public void deshabilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.disableUserById(idUsuario);
    }

    /**
     * Deshabilita un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario del usuario a deshabilitar.
     */
    @Override
    @Transactional
    public void deshabilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.disableUserByUsername(nombreUsuario);
    }

    /**
     * Habilita un usuario por su ID.
     *
     * @param idUsuario El ID del usuario a habilitar.
     */
    @Override
    @Transactional
    public void habilitarUsuarioPorId(Long idUsuario) {
        usuarioRepository.enableUserById(idUsuario);
    }

    /**
     * Habilita un usuario por su nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario del usuario a habilitar.
     */
    @Override
    @Transactional
    public void habilitarUsuarioPorNombreUsuario(String nombreUsuario) {
        usuarioRepository.enableUserByUsername(nombreUsuario);
    }

    /**
     * Comprueba si existe un usuario con el nombre de usuario proporcionado.
     *
     * @param nombreUsuario El nombre de usuario a comprobar.
     * @return true si existe un usuario con el nombre de usuario proporcionado, false en caso contrario.
     */
    @Override
    @Transactional
    public boolean existeUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsUsuarioByUsername(nombreUsuario);
    }
}
