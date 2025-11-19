package com.robinlb99.legalserviceportalapi.core.model.entity;

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
import java.time.LocalDateTime;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.model.enums.TipoRemitente;


/**
 * Entidad que representa un mensaje en un caso.
 */
@Entity
public class Mensaje implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del mensaje.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Contenido del mensaje.
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    /**
     * Fecha y hora de envío del mensaje.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha_envio;

    /**
     * Tipo de remitente del mensaje (por ejemplo, CLIENTE, ABOGADO).
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoRemitente remitente;

    /**
     * Caso al que pertenece el mensaje.
     */
    @ManyToOne
    @JoinColumn(name = "caso_id", nullable = false)
    private Caso caso;

    /**
     * Constructor por defecto.
     */
    public Mensaje() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id ID del mensaje.
     * @param contenido Contenido del mensaje.
     * @param fecha_envio Fecha y hora de envío del mensaje.
     * @param remitente Tipo de remitente del mensaje.
     * @param caso Caso al que pertenece el mensaje.
     */
    public Mensaje(
        Long id,
        String contenido,
        LocalDateTime fecha_envio,
        TipoRemitente remitente,
        Caso caso
    ) {
        this.id = id;
        this.contenido = contenido;
        this.fecha_envio = fecha_envio;
        this.remitente = remitente;
        this.caso = caso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(LocalDateTime fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public TipoRemitente getRemitente() {
        return remitente;
    }

    public void setRemitente(TipoRemitente remitente) {
        this.remitente = remitente;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
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
        Mensaje other = (Mensaje) obj;
        return Objects.equals(id, other.id);
    }
}

