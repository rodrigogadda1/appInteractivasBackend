package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="unidades")
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_unidad;
	
	@Column(name="piso")
	private String piso;
	
	@Column(name="unidad")
	private String unidad;
	
	@ManyToOne
	@JoinColumn(name="id_edificio", nullable = true)
	private Edificio edificio;
	
	public Unidad() {
		super();
	}
	
//	long idEdificio
	public Unidad(long id_unidad,  String piso, String unidad) {
		super();
		this.id_unidad = id_unidad;
		this.piso = piso;
		this.unidad = unidad;
//		this.idEdificio = idEdificio;
	}

	public long getId() {
		return id_unidad;
	}
	public void setId(long id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	@Override
	public String toString() {
		return "Unidad [id=" + id_unidad + ", idEdificio="  + ", piso=" + piso + ", unidad=" + unidad + "]";
	}

	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
//	public long getIdEdificio() {
//		return idEdificio;
//	}
//
//	public void setIdEdificio(long idEdificio) {
//		this.idEdificio = idEdificio;
//	}

}
