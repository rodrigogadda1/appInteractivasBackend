package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	
	public Especialidad() {
		super ();
	}
	public Especialidad(long id, String nombre, String descripcion) {
		super();
		this.id_especialidad = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public long getId() {
		return id_especialidad;
	}
	public void setId(long id) {
		this.id_especialidad = id;
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
	
	@Override
	public String toString() {
		return "Especialidad [id=" + id_especialidad + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}
