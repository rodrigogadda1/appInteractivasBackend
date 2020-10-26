package com.AplicacionesInteractivas.TP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="inspectores")
public class Inspector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_inspector;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@ManyToMany
	@JoinColumn(name="id_edificio", nullable = true)
	private List<Edificio> edificios;

	public Inspector() {
		super();
	}

	public Inspector(long id_inspector, String nombre, String apellido, List<Edificio> edificios) {
		super();
		this.id_inspector = id_inspector;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edificios = edificios;
	}

	public long getId_inspector() {
		return id_inspector;
	}

	public void setId_inspector(long id_inspector) {
		this.id_inspector = id_inspector;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Edificio> getUnidades() {
		return edificios;
	}

	public void setEdificios(List<Edificio> edificios) {
		this.edificios = edificios;
	}

}
