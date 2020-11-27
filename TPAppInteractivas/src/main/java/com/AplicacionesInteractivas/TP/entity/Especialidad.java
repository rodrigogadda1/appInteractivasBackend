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
@Table (name ="especialidades")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_especialidad;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@OneToMany
	@JoinColumn(name="id_especialidad", nullable = true)
	private List<Inspector> inspectores;

	
	public Especialidad() {
		super ();
	}


	public Especialidad(long id_especialidad, String nombre, String descripcion, List<Inspector> inspectores) {
		super();
		this.id_especialidad = id_especialidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.inspectores = inspectores;
	}


	@Override
	public String toString() {
		return "Especialidad [id_especialidad=" + id_especialidad + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", inspectores=" + inspectores + "]";
	}


	public long getId_especialidad() {
		return id_especialidad;
	}


	public void setId_especialidad(long id_especialidad) {
		this.id_especialidad = id_especialidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Inspector> getInspectores() {
		return inspectores;
	}


	public void setInspectores(List<Inspector> inspectores) {
		this.inspectores = inspectores;
	}

	
}
