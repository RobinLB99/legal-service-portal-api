package com.robinlb99.legalserviceportalapi.core.domain.entity;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.domain.enums.Role;

@Entity
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role rol;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha_registro;

    @Column(nullable = false)
    private boolean activo;

    @OneToOne(
        mappedBy = "usuario",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private PerfilUsuario perfilUsuario;

    public Usuario() {}

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

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
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
