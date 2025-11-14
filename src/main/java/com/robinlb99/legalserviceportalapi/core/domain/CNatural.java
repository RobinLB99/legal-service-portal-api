package com.robinlb99.legalserviceportalapi.core.domain;

import com.robinlb99.legalserviceportalapi.core.enums.EstadoCivil;
import com.robinlb99.legalserviceportalapi.core.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "cliente_natural")
public class CNatural extends Persona implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Cliente cliente;

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

    public CNatural() {}

    public CNatural(
        Cliente cliente,
        String nombres,
        String apellidos,
        String numero_cedula,
        LocalDate fecha_nacimiento,
        Genero genero,
        EstadoCivil estado_civil,
        String correo_electronico,
        String numero_telefono,
        String direccion_domicilio
    ) {
        this.id = cliente.getId();
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setNumero_cedula(numero_cedula);
        this.setCorreo_electronico(correo_electronico);
        this.setNumero_telefono(numero_telefono);
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.estado_civil = estado_civil;
        this.direccion_domicilio = direccion_domicilio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        CNatural other = (CNatural) obj;
        return (
            Objects.equals(id, other.id) &&
            Objects.equals(numero_cedula, other.numero_cedula)
        );
    }
}
