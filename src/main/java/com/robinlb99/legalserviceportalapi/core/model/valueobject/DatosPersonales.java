package com.robinlb99.legalserviceportalapi.core.model.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


/**
 * Objeto de valor que representa los datos personales de un individuo.
 * Esta clase es incrustable y se puede utilizar en otras entidades.
 */
@Embeddable
public class DatosPersonales {

    /**
     * Nombres de la persona.
     */
    @Column(nullable = false, length = 100)
    private String nombres;

    /**
     * Apellidos de la persona.
     */
    @Column(nullable = false, length = 100)
    private String apellidos;

    /**
     * Número de cédula de la persona.
     */
    @Column(nullable = false, unique = true, length = 10)
    private String numero_cedula;

    /**
     * Correo electrónico de la persona.
     */
    @Column(nullable = false, unique = true, length = 100)
    private String correo_electronico;

    /**
     * Número de teléfono de la persona.
     */
    @Column(nullable = false, length = 15)
    private String numero_telefono;

    /**
     * Constructor por defecto.
     */
    public DatosPersonales() {
    }

    /**
     * Constructor con todos los campos.
     *
     * @param nombres Nombres de la persona.
     * @param apellidos Apellidos de la persona.
     * @param numero_cedula Número de cédula de la persona.
     * @param correo_electronico Correo electrónico de la persona.
     * @param numero_telefono Número de teléfono de la persona.
     */
    public DatosPersonales(String nombres, String apellidos, String numero_cedula, String correo_electronico, String numero_telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numero_cedula = numero_cedula;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumero_cedula() {
        return numero_cedula;
    }

    public void setNumero_cedula(String numero_cedula) {
        this.numero_cedula = numero_cedula;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
}

