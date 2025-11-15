package com.robinlb99.legalserviceportalapi.core.repository;

import com.robinlb99.legalserviceportalapi.core.model.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Modifying
    @Query(
        "UPDATE Usuario u SET u.password_hash = :newPasswordHash WHERE u.id = :id"
    )
    public void updatePasswordEncode(Long id, String newPasswordHash);

    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    public Optional<Usuario> findByUsername(String username);

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = FALSE WHERE u.id = :id")
    public void disableUserById(Long id);

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = FALSE WHERE u.username = :username")
    public void disableUserByUsername(String username);

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = TRUE WHERE u.id = :id")
    public void enableUserById(Long id);

    @Modifying
    @Query("UPDATE Usuario u SET u.activo = TRUE WHERE u.username = :username")
    public void enableUserByUsername(String username);

    public boolean existsUsuarioByUsername(String username);
}
