package com.robinlb99.legalserviceportalapi.core.model.entity;

import com.robinlb99.legalserviceportalapi.common.util.JsonbConverter;
import com.robinlb99.legalserviceportalapi.core.model.enums.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
import java.util.Map;
import java.util.Objects;

/**
 * Entidad que representa un documento asociado a un caso.
 */
@Entity
public class Documento implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID del documento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del documento.
     */
    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Tipo de documento.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo_documento;

    /**
     * URL del archivo del documento.
     */
    @Column(nullable = false, length = 255)
    private String url_archivo;

    /**
     * Fecha y hora de subida del documento.
     */
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha_subida;

    /**
     * Caso al que pertenece el documento.
     */
    @ManyToOne
    @JoinColumn(nullable = false, name = "caso_id")
    private Caso caso;

    /**
     * Metadatos del documento, almacenados como JSON.
     */
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    private Map<String, Object> metadatos;

    /**
     * Constructor por defecto.
     */
    public Documento() {}

    /**
     * Constructor con todos los campos.
     *
     * @param id ID del documento.
     * @param nombre Nombre del documento.
     * @param tipo_documento Tipo de documento.
     * @param url_archivo URL del archivo del documento.
     * @param fecha_subida Fecha y hora de subida del documento.
     * @param caso Caso al que pertenece el documento.
     * @param metadatos Metadatos del documento.
     */
    public Documento(
        Long id,
        String nombre,
        TipoDocumento tipo_documento,
        String url_archivo,
        LocalDateTime fecha_subida,
        Caso caso,
        Map<String, Object> metadatos
    ) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_documento = tipo_documento;
        this.url_archivo = url_archivo;
        this.fecha_subida = fecha_subida;
        this.caso = caso;
        this.metadatos = metadatos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getUrl_archivo() {
        return url_archivo;
    }

    public void setUrl_archivo(String url_archivo) {
        this.url_archivo = url_archivo;
    }

    public LocalDateTime getFecha_subida() {
        return fecha_subida;
    }

    public void setFecha_subida(LocalDateTime fecha_subida) {
        this.fecha_subida = fecha_subida;
    }

    public Caso getCaso() {
        return caso;
    }

    public void setCaso(Caso caso) {
        this.caso = caso;
    }

    public Map<String, Object> getMetadatos() {
        return metadatos;
    }

    public void setMetadatos(Map<String, Object> metadatos) {
        this.metadatos = metadatos;
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
        Documento other = (Documento) obj;
        return Objects.equals(id, other.id);
    }
}
