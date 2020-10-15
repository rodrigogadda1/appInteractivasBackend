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
	private long id_administrado;
	
	@Column(name = "id_user")
	private String idUser;
	
	@Column(name = "tipo_administriado")
	private String tipo_administriado;

	public Administrado() {
		super();
	}

	public Administrado(long id, String idUser, String tipo_administriado) {
		super();
		this.id_administrado = id;
		this.idUser = idUser;
		this.tipo_administriado = tipo_administriado;
	}

	@Override
	public String toString() {
		return "Administrado [id=" + id_administrado + ", idUser=" + idUser + ", tipo_administriado=" + tipo_administriado
				+  "]";
	}

	public long getId() {
		return id_administrado;
	}

	public void setId(long id) {
		this.id_administrado = id;
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
	
}
