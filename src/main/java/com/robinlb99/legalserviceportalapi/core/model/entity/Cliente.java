package com.robinlb99.legalserviceportalapi.core.model.entity;

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

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;


/**
 * Entidad abstracta que representa a un cliente.
 * Esta clase es la base para los diferentes tipos de clientes.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del cliente, que es el mismo que el ID del usuario asociado.
     */
    @Id
    private Long id;

    /**
     * Usuario asociado a este cliente.
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    /**
     * Tipo de cliente (por ejemplo, PERSONA_NATURAL, EMPRESA).
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo_cliente;

    /**
     * Constructor por defecto.
     */
    public Cliente() {}

    /**
     * Constructor con el usuario y el tipo de cliente.
     *
     * @param usuario El usuario asociado.
     * @param tipo_cliente El tipo de cliente.
     */
    public Cliente(Usuario usuario, TipoCliente tipo_cliente) {
        this.usuario = usuario;
        this.tipo_cliente = tipo_cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

