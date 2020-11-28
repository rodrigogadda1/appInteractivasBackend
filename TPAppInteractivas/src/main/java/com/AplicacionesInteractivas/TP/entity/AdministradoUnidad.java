package com.AplicacionesInteractivas.TP.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="administrad_unidad")
public class AdministradoUnidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_administradounidad;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_administradounidad", nullable = true)
	private List<Unidad> unidades;
	
	@Column(name = "relacion")
	private String relacion;

	public AdministradoUnidad() {
		super();
	}

	public AdministradoUnidad(long id_administradounidad, List<Unidad> unidades, String relacion) {
		super();
		this.id_administradounidad = id_administradounidad;
		this.unidades = unidades;
		this.relacion = relacion;
	}

	@Override
	public String toString() {
		return "AdministradoUnidad [id_administradounidad=" + id_administradounidad + ", unidades=" + unidades
				+ ", relacion=" + relacion + "]";
	}

	public long getId_administradounidad() {
		return id_administradounidad;
	}

	public void setId_administradounidad(long id_administradounidad) {
		this.id_administradounidad = id_administradounidad;
	}

	public List<Unidad> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

}