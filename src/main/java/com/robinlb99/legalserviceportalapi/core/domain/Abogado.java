package com.robinlb99.legalserviceportalapi.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Abogado extends Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private PerfilUsuario perfil_usuario;

    @Column(nullable = false, length = 100)
    private String especialidad;

    @Column(nullable = false, length = 100)
    private String licencia;

    public Abogado() {}

    public Abogado(
        PerfilUsuario perfil_usuario,
        String nombres,
        String apellidos,
        String numero_cedula,
        String correo_electronico,
        String numero_telefono,
        String especialidad,
        String licencia
    ) {
        this.id = perfil_usuario.getId();
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setNumero_cedula(numero_cedula);
        this.setCorreo_electronico(correo_electronico);
        this.setNumero_telefono(numero_telefono);
        this.especialidad = especialidad;
        this.licencia = licencia;
    }

    public PerfilUsuario getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(PerfilUsuario perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero_cedula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Abogado other = (Abogado) obj;
        return (
            Objects.equals(id, other.id) &&
            Objects.equals(numero_cedula, other.numero_cedula)
        );
    }
}
