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
	
	@Column(name="idEdificio")
	private long idEdificio;
	
	@Column(name="piso")
	private String piso;
	
	@Column(name="unidad")
	private String unidad;
	
	public Unidad() {
		super();
	}
	
	public Unidad(long id, long idEdificio, String piso, String unidad) {
		super();
		this.id = id;
		this.piso = piso;
		this.unidad = unidad;
		this.idEdificio = idEdificio;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	@Override
	public String toString() {
		return "Unidad [id=" + id + ", idEdificio=" + idEdificio + ", piso=" + piso + ", unidad=" + unidad + "]";
	}

	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	public long getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(long idEdificio) {
		this.idEdificio = idEdificio;
	}

}
