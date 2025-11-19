package com.robinlb99.legalserviceportalapi.core.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.model.valueobject.DatosPersonales;


/**
 * Entidad que representa a un abogado.
 */
@Entity
public class Abogado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del abogado, que es el mismo que el ID del usuario asociado.
     */
    @Id
    private Long id;

    /**
     * Usuario asociado a este abogado.
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    /**
     * Datos personales del abogado.
     */
    @Embedded
    private DatosPersonales datosPersonales;

    /**
     * Especialidad del abogado.
     */
    @Column(nullable = false, length = 100)
    private String especialidad;

    /**
     * Número de licencia del abogado.
     */
    @Column(nullable = false, length = 100)
    private String licencia;

    /**
     * Constructor por defecto.
     */
    public Abogado() {}

    /**
     * Constructor con todos los campos.
     *
     * @param usuario Usuario asociado.
     * @param nombres Nombres del abogado.
     * @param apellidos Apellidos del abogado.
     * @param numero_cedula Número de cédula del abogado.
     * @param correo_electronico Correo electrónico del abogado.
     * @param numero_telefono Número de teléfono del abogado.
     * @param especialidad Especialidad del abogado.
     * @param licencia Número de licencia del abogado.
     */
    public Abogado(
        Usuario usuario,
        String nombres,
        String apellidos,
        String numero_cedula,
        String correo_electronico,
        String numero_telefono,
        String especialidad,
        String licencia
    ) {
        this.usuario = usuario;
        this.datosPersonales = new DatosPersonales(
                nombres,
                apellidos,
                numero_cedula,
                correo_electronico,
                numero_telefono
        );
        this.especialidad = especialidad;
        this.licencia = licencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
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
        return Objects.hash(id, datosPersonales.getNumero_cedula());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Abogado other = (Abogado) obj;
        return (
            Objects.equals(id, other.id) &&
            Objects.equals(
                datosPersonales.getNumero_cedula(),
                other.datosPersonales.getNumero_cedula()
            )
        );
    }
}