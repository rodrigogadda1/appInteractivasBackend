package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrado")
public class Administrado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "idUser")
	private String idUser;
	
	@Column(name = "tipo_administriado")
	private String tipo_administriado;
	
	@Column(name = "id_unidad")
	private String idUnidad;

	public Administrado() {
		super();
	}

	public Administrado(long id, String idUser, String tipo_administriado, String idUnidad) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.tipo_administriado = tipo_administriado;
		this.idUnidad = idUnidad;
	}

	@Override
	public String toString() {
		return "Administrado [id=" + id + ", idUser=" + idUser + ", tipo_administriado=" + tipo_administriado
				+ ", idUnidad=" + idUnidad + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}
	
	
}
