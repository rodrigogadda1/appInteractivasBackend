package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inspector_especialidad")
public class InspectorEspecialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_inspectorespecialidad;
	
	@ManyToOne
	@JoinColumn(name="id_inspector")
	private Inspector inspector;
	
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;

	@Override
	public String toString() {
		return "InspectorEspecialidad [id_inspectorespecialidad=" + id_inspectorespecialidad + ", inspector="
				+ inspector + ", especialidad=" + especialidad + "]";
	}

	public InspectorEspecialidad() {
		super();
	}

	public InspectorEspecialidad(long id_inspectorespecialidad, Inspector inspector, Especialidad especialidad) {
		super();
		this.id_inspectorespecialidad = id_inspectorespecialidad;
		this.inspector = inspector;
		this.especialidad = especialidad;
	}

	public long getId_inspectorespecialidad() {
		return id_inspectorespecialidad;
	}

	public void setId_inspectorespecialidad(long id_inspectorespecialidad) {
		this.id_inspectorespecialidad = id_inspectorespecialidad;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
}
