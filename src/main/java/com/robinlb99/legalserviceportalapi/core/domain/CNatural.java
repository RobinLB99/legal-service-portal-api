package com.robinlb99.legalserviceportalapi.core.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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

@Entity
@Table(name = "cliente_natural")
public class CNatural implements Serializable {

	@Id
	private Long id;

	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Cliente cliente;

	@Column(nullable = false, length = 100)
	private String nombres;

	@Column(nullable = false, length = 100)
	private String apellidos;

	@Column(nullable = false, unique = true, length = 10)
	private String numero_cedula;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate fecha_nacimiento;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estado_civil;

	@Column(nullable = false, unique = true, length = 100)
	private String correo_electronico;

	@Column(nullable = false, length = 12)
	private String numero_telefono;

	@Column(nullable = false, length = 100)
	private String direccion_domicilio;

	public CNatural() {
	}

	public CNatural(Cliente cliente, String nombres, String apellidos, String numero_cedula, LocalDate fecha_nacimiento,
			Genero genero, EstadoCivil estado_civil, String correo_electronico, String numero_telefono,
			String direccion_domicilio) {
		this.id = cliente.getId();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.numero_cedula = numero_cedula;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.estado_civil = estado_civil;
		this.correo_electronico = correo_electronico;
		this.numero_telefono = numero_telefono;
		this.direccion_domicilio = direccion_domicilio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CNatural other = (CNatural) obj;
		return Objects.equals(id, other.id) && Objects.equals(numero_cedula, other.numero_cedula);
	}

}
