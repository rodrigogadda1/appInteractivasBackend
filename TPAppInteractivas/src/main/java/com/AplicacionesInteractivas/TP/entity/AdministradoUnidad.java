package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="administrad_unidad")
public class AdministradoUnidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_administradounidad;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_unidad")
	private Unidad unidad;
	
	@Column(name = "relacion")
	private String relacion;

	public AdministradoUnidad() {
		super();
	}

	public AdministradoUnidad(long id_administradounidad, Unidad unidad, String relacion) {
		super();
		this.id_administradounidad = id_administradounidad;
		this.unidad = unidad;
		this.relacion = relacion;
	}

	@Override
	public String toString() {
		return "AdministradoUnidad [id=" + id_administradounidad + ", unidad=" + unidad + ", relacion="
				+ relacion + "]";
	}

	public long getId() {
		return id_administradounidad;
	}

	public void setId(long id_administradounidad) {
		this.id_administradounidad = id_administradounidad;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	
	

}
