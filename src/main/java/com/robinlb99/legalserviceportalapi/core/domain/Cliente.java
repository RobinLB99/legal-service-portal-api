package com.robinlb99.legalserviceportalapi.core.domain;

import com.robinlb99.legalserviceportalapi.core.enums.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private PerfilUsuario perfil_usuario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo_cliente;

    public Cliente() {}

    public Cliente(PerfilUsuario perfil_usuario, TipoCliente tipo_cliente) {
        this.id = perfil_usuario.getId();
        this.perfil_usuario = perfil_usuario;
        this.tipo_cliente = tipo_cliente;
    }

    public PerfilUsuario getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(PerfilUsuario perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public TipoCliente getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(TipoCliente tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public Long getId() {
        return id;
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
        Cliente other = (Cliente) obj;
        return Objects.equals(id, other.id);
    }
}
