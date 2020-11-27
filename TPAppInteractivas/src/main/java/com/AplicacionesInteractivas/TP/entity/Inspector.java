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
	@JoinColumn(name="id_inspector", nullable = true)
	private List<Edificio> edificios;	
	
	@OneToMany
	@JoinColumn(name="id_inspector", nullable = true)
	private List<Especialidad> especialidades;	

	public Inspector() {
		super();
	}

	public Inspector(long id_inspector, long id_user, List<Edificio> edificios, List<Especialidad> especialidades) {
		super();
		this.id_inspector = id_inspector;
		this.id_user = id_user;
		this.edificios = edificios;
		this.especialidades = especialidades;
	}

	@Override
	public String toString() {
		return "Inspector [id_inspector=" + id_inspector + ", id_user=" + id_user + ", edificios=" + edificios
				+ ", especialidades=" + especialidades + "]";
	}

	public long getId_inspector() {
		return id_inspector;
	}

	public void setId_inspector(long id_inspector) {
		this.id_inspector = id_inspector;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public List<Edificio> getEdificios() {
		return edificios;
	}

	public void setEdificios(List<Edificio> edificios) {
		this.edificios = edificios;
	}

	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
}
