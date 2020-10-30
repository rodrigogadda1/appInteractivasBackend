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
@Table(name="inspectores")
public class Inspector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_inspector;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@OneToMany
	@JoinColumn(name="id_inspectoredificio")
	private List<InspectorEdificio> inspectoredificio;	

	public Inspector() {
		super();
	}

	@Override
	public String toString() {
		return "Inspector [id_inspector=" + id_inspector + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", inspectoredificio=" + inspectoredificio + "]";
	}


	public Inspector(long id_inspector, String nombre, String apellido, List<InspectorEdificio> inspectoredificio) {
		super();
		this.id_inspector = id_inspector;
		this.nombre = nombre;
		this.apellido = apellido;
		this.inspectoredificio = inspectoredificio;
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


	public List<InspectorEdificio> getInspectoredificio() {
		return inspectoredificio;
	}


	public void setInspectoredificio(List<InspectorEdificio> inspectoredificio) {
		this.inspectoredificio = inspectoredificio;
	}



}
