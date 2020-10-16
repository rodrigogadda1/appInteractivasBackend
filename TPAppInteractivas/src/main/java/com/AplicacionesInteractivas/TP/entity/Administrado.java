package com.AplicacionesInteractivas.TP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="administrado")
public class Administrado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_administrado;
	
	@Column(name = "id_user")
	private String idUser;
	
	@Column(name = "tipo_administriado")
	private String tipo_administriado;
	
	@OneToMany
	@JoinColumn(name="id_administrado", nullable = true)
	private List<Unidad> unidades;

	public Administrado() {
		super();
	}

	public Administrado(long id_administrado, String idUser, String tipo_administriado, List<Unidad> unidades) {
		super();
		this.id_administrado = id_administrado;
		this.idUser = idUser;
		this.tipo_administriado = tipo_administriado;
		this.unidades = unidades;
	}



	public long getId_administrado() {
		return id_administrado;
	}

	public void setId_administrado(long id_administrado) {
		this.id_administrado = id_administrado;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getTipo_administriado() {
		return tipo_administriado;
	}

	public void setTipo_administriado(String tipo_administriado) {
		this.tipo_administriado = tipo_administriado;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Administrado [id=" + id_administrado + ", idUser=" + idUser + ", tipo_administriado=" + tipo_administriado
				+  "]";
	}

	
	
}
