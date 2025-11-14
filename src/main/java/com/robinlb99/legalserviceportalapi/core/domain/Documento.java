package com.robinlb99.legalserviceportalapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.common.util.JsonbConverter;
import com.robinlb99.legalserviceportalapi.core.enums.TipoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Documento implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoDocumento tipo_documento;
	
	@Column(nullable = false, length = 255)
	private String url_archivo;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha_subida;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Caso caso;
	
	@Column(columnDefinition = "jsonb")
	@Convert(converter = JsonbConverter.class)
	private Map<String, Object> metadatos;

	public Documento() {
	}

	public Documento(Long id, String nombre, TipoDocumento tipo_documento, String url_archivo,
			LocalDateTime fecha_subida, Caso caso, Map<String, Object> metadatos) {
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(id, other.id);
	}

}
