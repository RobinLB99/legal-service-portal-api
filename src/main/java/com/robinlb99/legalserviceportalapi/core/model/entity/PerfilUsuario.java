package com.robinlb99.legalserviceportalapi.core.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoPerfil;

@Entity
@Table(name = "perfil_usuario")
public class PerfilUsuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipo_perfil;

    public PerfilUsuario() {}

    public PerfilUsuario(TipoPerfil tipo_perfil, Usuario usuario) {
        this.tipo_perfil = tipo_perfil;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public TipoPerfil getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(TipoPerfil tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PerfilUsuario other = (PerfilUsuario) obj;
        return Objects.equals(id, other.id);
    }
}
