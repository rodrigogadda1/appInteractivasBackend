package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidades")
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="edificioId")
	private long edificioId;
	
	@Column(name="piso")
	private String piso;
	
	@Column(name="unidad")
	private String unidad;
	
	public Unidad() {
		super();
	}
	public Unidad(long id, long edificioId, String piso, String unidad) {
		super();
		this.id = id;
		this.edificioId = edificioId;
		this.piso = piso;
		this.unidad = unidad;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEdificioId() {
		return edificioId;
	}
	public void setEdificioId(long edificioId) {
		this.edificioId = edificioId;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
