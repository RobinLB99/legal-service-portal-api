package com.robinlb99.legalserviceportalapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Abogado implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private PerfilUsuario perfil_usuario;

	@Column(nullable = false, length = 100)
	private String nombres;

	@Column(nullable = false, length = 100)
	private String apellidos;

	@Column(nullable = false, unique = true, length = 100)
	private String numero_cedula;

	@Column(nullable = false, unique = true, length = 100)
	private String correo_electronico;

	@Column(nullable = false, length = 13)
	private String numero_telefono;

	@Column(nullable = false, length = 100)
	private String especialidad;

	@Column(nullable = false, length = 100)
	private String licencia;

	public Abogado() {
	}

	public Abogado(PerfilUsuario perfil_usuario, String nombres, String apellidos, String numero_cedula,
			String correo_electronico, String numero_telefono, String especialidad, String licencia) {
		this.id = perfil_usuario.getId();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.numero_cedula = numero_cedula;
		this.correo_electronico = correo_electronico;
		this.numero_telefono = numero_telefono;
		this.especialidad = especialidad;
		this.licencia = licencia;
	}

	public PerfilUsuario getPerfil_usuario() {
		return perfil_usuario;
	}

	public void setPerfil_usuario(PerfilUsuario perfil_usuario) {
		this.perfil_usuario = perfil_usuario;
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
		return Objects.hash(id, numero_cedula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abogado other = (Abogado) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero_cedula, other.numero_cedula);
	}

}
