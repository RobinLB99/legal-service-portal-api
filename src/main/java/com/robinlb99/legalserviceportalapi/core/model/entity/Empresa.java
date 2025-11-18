package com.robinlb99.legalserviceportalapi.core.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;

@Entity
@Table(name = "empresa")
public class Empresa extends Cliente {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 100)
    private String razon_social;

    @Column(nullable = false, unique = true, length = 13)
    private String ruc;

    @Column(nullable = false, length = 100)
    private String representante_legal;

    @Column(nullable = false, length = 100)
    private String correo_institucional;

    @Column(nullable = false, length = 13)
    private String telefono_institucional;

    @Column(nullable = false, length = 100)
    private String direccion_institucional;

    public Empresa() {}

    public Empresa(
        Usuario usuario,
        String razon_social,
        String ruc,
        String representante_legal,
        String correo_institucional,
        String telefono_institucional,
        String direccion_institucional
    ) {
        super(usuario, TipoCliente.JURIDICO);
        this.razon_social = razon_social;
        this.ruc = ruc;
        this.representante_legal = representante_legal;
        this.correo_institucional = correo_institucional;
        this.telefono_institucional = telefono_institucional;
        this.direccion_institucional = direccion_institucional;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getCorreo_institucional() {
        return correo_institucional;
    }

    public void setCorreo_institucional(String correo_institucional) {
        this.correo_institucional = correo_institucional;
    }

    public String getTelefono_institucional() {
        return telefono_institucional;
    }

    public void setTelefono_institucional(String telefono_institucional) {
        this.telefono_institucional = telefono_institucional;
    }

    public String getDireccion_institucional() {
        return direccion_institucional;
    }

    public void setDireccion_institucional(String direccion_institucional) {
        this.direccion_institucional = direccion_institucional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), ruc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Empresa other = (Empresa) obj;
        return (
            Objects.equals(getId(), other.getId()) &&
            Objects.equals(ruc, other.ruc)
        );
    }
}