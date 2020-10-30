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
	
	@Column(name = "id_user")
	private long id_user;
	
	@OneToMany
	@JoinColumn(name="id_inspectoredificio")
	private List<InspectorEdificio> inspectoredificio;	

	public Inspector() {
		super();
	}

	@Override
	public String toString() {
		return "Inspector [id_inspector=" + id_inspector + ", id_user=" + id_user + ", inspectoredificio="
				+ inspectoredificio + "]";
	}



	public Inspector(long id_inspector, long id_user, List<InspectorEdificio> inspectoredificio) {
		super();
		this.id_inspector = id_inspector;
		this.id_user = id_user;
		this.inspectoredificio = inspectoredificio;
	}



	public long getId_inspector() {
		return id_inspector;
	}


	public void setId_inspector(long id_inspector) {
		this.id_inspector = id_inspector;
	}


	public List<InspectorEdificio> getInspectoredificio() {
		return inspectoredificio;
	}


	public void setInspectoredificio(List<InspectorEdificio> inspectoredificio) {
		this.inspectoredificio = inspectoredificio;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

}
