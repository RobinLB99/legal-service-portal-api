package com.robinlb99.legalserviceportalapi.core.model.entity;

import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCivil;
import com.robinlb99.legalserviceportalapi.core.model.enums.Genero;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;
import com.robinlb99.legalserviceportalapi.core.model.valueobject.DatosPersonales;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad que representa a un cliente de tipo persona natural.
 * Extiende de la clase Cliente.
 */
@Entity
@Table(name = "persona_natural")
public class PersonaNatural extends Cliente {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Datos personales de la persona natural.
     */
    @Embedded
    private DatosPersonales datosPersonales;

    /**
     * Fecha de nacimiento de la persona natural.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;

    /**
     * Género de la persona natural.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    /**
     * Estado civil de la persona natural.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estado_civil;

    /**
     * Dirección de domicilio de la persona natural.
     */
    @Column(nullable = false, length = 100)
    private String direccion_domicilio;

    /**
     * Constructor por defecto.
     */
    public PersonaNatural() {}

    /**
     * Constructor con todos los campos.
     *
     * @param usuario Usuario asociado.
     * @param nombres Nombres de la persona natural.
     * @param apellidos Apellidos de la persona natural.
     * @param numero_cedula Número de cédula de la persona natural.
     * @param correo_electronico Correo electrónico de la persona natural.
     * @param numero_telefono Número de teléfono de la persona natural.
     * @param fecha_nacimiento Fecha de nacimiento de la persona natural.
     * @param genero Género de la persona natural.
     * @param estado_civil Estado civil de la persona natural.
     * @param direccion_domicilio Dirección de domicilio de la persona natural.
     */
    public PersonaNatural(
        Usuario usuario,
        String nombres,
        String apellidos,
        String numero_cedula,
        String correo_electronico,
        String numero_telefono,
        LocalDate fecha_nacimiento,
        Genero genero,
        EstadoCivil estado_civil,
        String direccion_domicilio
    ) {
        super(usuario, TipoCliente.NATURAL);
        this.datosPersonales = new DatosPersonales(
            nombres,
            apellidos,
            numero_cedula,
            correo_electronico,
            numero_telefono
        );
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.estado_civil = estado_civil;
        this.direccion_domicilio = direccion_domicilio;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDireccion_domicilio() {
        return direccion_domicilio;
    }

    public void setDireccion_domicilio(String direccion_domicilio) {
        this.direccion_domicilio = direccion_domicilio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), datosPersonales.getNumero_cedula());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        PersonaNatural other = (PersonaNatural) obj;
        return (
            Objects.equals(getId(), other.getId()) &&
            Objects.equals(
                datosPersonales.getNumero_cedula(),
                other.datosPersonales.getNumero_cedula()
            )
        );
    }
}