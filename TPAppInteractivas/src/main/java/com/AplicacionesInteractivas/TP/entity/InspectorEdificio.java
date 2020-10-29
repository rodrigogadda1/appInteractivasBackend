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
@Table(name="inspector_edificio")
public class InspectorEdificio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_inspectoredificio;
	
	@ManyToOne
	@JoinColumn(name="id_inspector")
	private Inspector inspector;
	
	@ManyToOne
	@JoinColumn(name="id_edificio")
	private Edificio edificio;

	
	
	@Override
	public String toString() {
		return "InspectorEdificio [id_inspectoredificio=" + id_inspectoredificio + ", inspector=" + inspector
				+ ", edificio=" + edificio + "]";
	}



	public InspectorEdificio() {
		super();
	}

	public InspectorEdificio(long id_inspectoredificio, Inspector inspector, Edificio edificio) {
		super();
		this.id_inspectoredificio = id_inspectoredificio;
		this.inspector = inspector;
		this.edificio = edificio;
	}

	public long getId_inspectoredificio() {
		return id_inspectoredificio;
	}

	public void setId_inspectoredificio(long id_inspectoredificio) {
		this.id_inspectoredificio = id_inspectoredificio;
	}

	public Inspector getInspector() {
		return inspector;
	}

	public void setInspector(Inspector inspector) {
		this.inspector = inspector;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	
}
