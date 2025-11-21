package com.robinlb99.legalserviceportalapi.core.model.entity;

import com.robinlb99.legalserviceportalapi.core.model.enums.EstadoCaso;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoCaso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad que representa un caso legal.
 */
@Entity
public class Caso implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del caso.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título del caso.
     */
    @Column(nullable = false, length = 100)
    private String titulo;

    /**
     * Descripción del caso.
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Estado actual del caso.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCaso estado_caso;

    /**
     * Fecha de creación del caso.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_creacion;

    /**
     * Fecha de la última actualización del caso.
     */
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_actualizacion;

    /**
     * Tipo de caso legal.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCaso tipo_caso;

    /**
     * Cliente asociado al caso.
     */
    @ManyToOne
    @JoinColumn(nullable = false, name = "cliente_id")
    private Cliente cliente;

    /**
     * Abogado asignado al caso.
     */
    @ManyToOne
    @JoinColumn(nullable = false, name = "abogado_id")
    private Abogado abogado;

    /**
     * Constructor por defecto.
     */
    public Caso() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id ID del caso.
     * @param titulo Título del caso.
     * @param descripcion Descripción del caso.
     * @param estado_caso Estado actual del caso.
     * @param fecha_creacion Fecha de creación del caso.
     * @param fecha_actualizacion Ultima fecha de actualización del caso.
     * @param tipo_caso Tipo de caso legal.
     * @param cliente Cliente asociado al caso.
     * @param abogado Abogado asignado al caso.
     */
    public Caso(
        Long id,
        String titulo,
        String descripcion,
        EstadoCaso estado_caso,
        LocalDate fecha_creacion,
        LocalDate fecha_actualizacion,
        TipoCaso tipo_caso,
        Cliente cliente,
        Abogado abogado
    ) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado_caso = estado_caso;
        this.fecha_creacion = fecha_creacion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.tipo_caso = tipo_caso;
        this.cliente = cliente;
        this.abogado = abogado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoCaso getEstado_caso() {
        return estado_caso;
    }

    public void setEstado_caso(EstadoCaso estado_caso) {
        this.estado_caso = estado_caso;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDate fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public TipoCaso getTipo_caso() {
        return tipo_caso;
    }

    public void setTipo_caso(TipoCaso tipo_caso) {
        this.tipo_caso = tipo_caso;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Abogado getAbogado() {
        return abogado;
    }

    public void setAbogado(Abogado abogado) {
        this.abogado = abogado;
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
        Caso other = (Caso) obj;
        return Objects.equals(id, other.id);
    }
}
