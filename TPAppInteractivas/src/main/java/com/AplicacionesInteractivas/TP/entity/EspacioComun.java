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
@Table(name="EspaciosComunes")
public class EspacioComun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_espaciocomun;
		
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_edificio", nullable = true)
	private Edificio edificio;
	
	public EspacioComun() {
		super();
	}
	public EspacioComun(long id, String nombre, String descripcion) {
		super();
		this.id_espaciocomun = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public long getId() {
		return id_espaciocomun;
	}
	public void setId(long id) {
		this.id_espaciocomun = id;
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
		return "EspacioComun [id=" + id_espaciocomun + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	

}

