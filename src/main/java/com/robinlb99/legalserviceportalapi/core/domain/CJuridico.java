package com.robinlb99.legalserviceportalapi.core.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_juridico")
public class CJuridico implements Serializable {

	@Id
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Cliente cliente;

	@Column(nullable = false, length = 100)
	private String razon_social;

	@Column(nullable = false, unique = true, length = 13)
	private String ruc;

	@Column(nullable = false, length = 100)
	private String representante_legal;

	@Column(nullable = false, length = 100)
	private String correo_institucional;

	@Column(nullable = false, length = 13)
	private String telefono_institucional;

	@Column(nullable = false, length = 100)
	private String direccion_institucional;

	public CJuridico() {
	}

	public CJuridico(Cliente cliente, String razon_social, String ruc, String representante_legal,
			String correo_institucional, String telefono_institucional, String direccion_institucional) {
		this.id = cliente.getId();
		this.razon_social = razon_social;
		this.ruc = ruc;
		this.representante_legal = representante_legal;
		this.correo_institucional = correo_institucional;
		this.telefono_institucional = telefono_institucional;
		this.direccion_institucional = direccion_institucional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRepresentante_legal() {
		return representante_legal;
	}

	public void setRepresentante_legal(String representante_legal) {
		this.representante_legal = representante_legal;
	}

	public String getCorreo_institucional() {
		return correo_institucional;
	}

	public void setCorreo_institucional(String correo_institucional) {
		this.correo_institucional = correo_institucional;
	}

	public String getTelefono_institucional() {
		return telefono_institucional;
	}

	public void setTelefono_institucional(String telefono_institucional) {
		this.telefono_institucional = telefono_institucional;
	}

	public String getDireccion_institucional() {
		return direccion_institucional;
	}

	public void setDireccion_institucional(String direccion_institucional) {
		this.direccion_institucional = direccion_institucional;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ruc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CJuridico other = (CJuridico) obj;
		return Objects.equals(id, other.id) && Objects.equals(ruc, other.ruc);
	}

}
