package com.robinlb99.legalserviceportalapi.core.model.entity;

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

import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCivil;
import com.robinlb99.legalserviceportalapi.core.model.enums.Genero;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCliente;
import com.robinlb99.legalserviceportalapi.core.model.valueobject.DatosPersonales;

@Entity
@Table(name = "persona_natural")
public class PersonaNatural extends Cliente {

    @Serial
    private static final long serialVersionUID = 1L;

    @Embedded
    private DatosPersonales datosPersonales;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estado_civil;

    @Column(nullable = false, length = 100)
    private String direccion_domicilio;

    public PersonaNatural() {}

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