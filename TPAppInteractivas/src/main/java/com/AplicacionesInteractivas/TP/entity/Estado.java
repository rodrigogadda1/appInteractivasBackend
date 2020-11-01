package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="estados")
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_estado;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", descripcion=" + descripcion + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Estado() {
		super();
	}

	public Estado(long id_estado, String descripcion) {
		super();
		this.id_estado = id_estado;
		this.descripcion = descripcion;
	}

	public long getId_estado() {
		return id_estado;
	}

	public void setId_estado(long id_estado) {
		this.id_estado = id_estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
