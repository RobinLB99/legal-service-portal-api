package com.robinlb99.legalserviceportalapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.robinlb99.legalserviceportalapi.core.enums.TipoPerfil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_usuario")
public class PerfilUsuario implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoPerfil tipo_perfil;

	@OneToOne(mappedBy = "id")
	@JoinColumn(name = "id_usuario", unique = true, nullable = false)
	private Usuario usuario;

	public PerfilUsuario() {
	}

	public PerfilUsuario(Long id, TipoPerfil tipo_perfil, Usuario usuario) {
		this.id = id;
		this.tipo_perfil = tipo_perfil;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPerfil getTipo_perfil() {
		return tipo_perfil;
	}

	public void setTipo_perfil(TipoPerfil tipo_perfil) {
		this.tipo_perfil = tipo_perfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		PerfilUsuario other = (PerfilUsuario) obj;
		return Objects.equals(id, other.id);
	}

}
