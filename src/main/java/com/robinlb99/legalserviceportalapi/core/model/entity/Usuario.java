package com.robinlb99.legalserviceportalapi.core.model.entity;

import com.robinlb99.legalserviceportalapi.core.model.enums.Role;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad que representa a un usuario del sistema.
 */
@Entity
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario único.
     */
    @Column(unique = true, nullable = false)
    private String username;

    /**
     * Hash de la contraseña del usuario.
     */
    @Column(nullable = false)
    private String password_hash;

    /**
     * Rol del usuario en el sistema.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role rol;

    /**
     * Fecha y hora de registro del usuario.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha_registro;

    /**
     * Indica si el usuario está activo o no.
     */
    @Column(nullable = false)
    private boolean activo;

    /**
     * Constructor por defecto.
     */
    public Usuario() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id ID del usuario.
     * @param username Nombre de usuario.
     * @param password_hash Hash de la contraseña.
     * @param rol Rol del usuario.
     * @param fecha_registro Fecha y hora de registro.
     * @param activo Estado de activación del usuario.
     */
    public Usuario(
        Long id,
        String username,
        String password_hash,
        Role rol,
        LocalDateTime fecha_registro,
        boolean activo
    ) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
        this.rol = rol;
        this.fecha_registro = fecha_registro;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario user = (Usuario) o;
        return (
            Objects.equals(id, user.id) &&
            Objects.equals(username, user.username)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
