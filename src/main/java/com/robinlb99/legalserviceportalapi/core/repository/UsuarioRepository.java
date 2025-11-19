package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Usuario.
 * Proporciona métodos para realizar operaciones de base de datos en la entidad Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Actualiza el hash de la contraseña de un usuario por su ID.
     *
     * @param id El ID del usuario.
     * @param newPasswordHash El nuevo hash de la contraseña.
     */
    @Modifying
    @Query(
        "UPDATE Usuario u SET u.password_hash = :newPasswordHash WHERE u.id = :id"
    )
    public void updatePasswordEncode(Long id, String newPasswordHash);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Un Optional que contiene el usuario si se encuentra, o un Optional vacío si no.
     */
    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    public Optional<Usuario> findByUsername(String username);

    /**
     * Desactiva un usuario por su ID.
     *
     * @param id El ID del usuario a desactivar.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.activo = FALSE WHERE u.id = :id")
    public void disableUserById(Long id);

    /**
     * Desactiva un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario a desactivar.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.activo = FALSE WHERE u.username = :username")
    public void disableUserByUsername(String username);

    /**
     * Activa un usuario por su ID.
     *
     * @param id El ID del usuario a activar.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.activo = TRUE WHERE u.id = :id")
    public void enableUserById(Long id);

    /**
     * Activa un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario del usuario a activar.
     */
    @Modifying
    @Query("UPDATE Usuario u SET u.activo = TRUE WHERE u.username = :username")
    public void enableUserByUsername(String username);

    /**
     * Comprueba si existe un usuario con el nombre de usuario proporcionado.
     *
     * @param username El nombre de usuario a comprobar.
     * @return true si existe un usuario con el nombre de usuario proporcionado, false en caso contrario.
     */
    public boolean existsUsuarioByUsername(String username);
}

