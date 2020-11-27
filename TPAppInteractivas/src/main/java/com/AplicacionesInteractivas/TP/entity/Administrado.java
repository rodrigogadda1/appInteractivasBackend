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
@Table(name="administrado")
public class Administrado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_administrado;
	
	@Column(name = "id_user")
	private long id_user;
	
	@OneToMany(cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	@JoinColumn(name="id_administrado")
	private List<AdministradoUnidad> administradoUnidades;
	
	@OneToMany(
	        mappedBy = "administrado",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Reclamo> reclamos;
	
	public Administrado() {
		super();
	}

	public Administrado(long id_administrado, long id_user, List<AdministradoUnidad> administradoUnidades,
			List<Reclamo> reclamo) {
		super();
		this.id_administrado = id_administrado;
		this.id_user = id_user;
		this.administradoUnidades = administradoUnidades;
		this.reclamos = reclamo;
	}

	@Override
	public String toString() {
		return "Administrado [id_administrado=" + id_administrado + ", id_user=" + id_user + ", administradoUnidades="
				+ administradoUnidades + ", reclamo=" + reclamos + "]";
	}

	public long getId_administrado() {
		return id_administrado;
	}

	public void setId_administrado(long id_administrado) {
		this.id_administrado = id_administrado;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public List<AdministradoUnidad> getAdministradoUnidades() {
		return administradoUnidades;
	}

	public void setAdministradoUnidades(List<AdministradoUnidad> administradoUnidades) {
		this.administradoUnidades = administradoUnidades;
	}

	public List<Reclamo> getReclamo() {
		return reclamos;
	}

	public void setReclamo(List<Reclamo> reclamo) {
		this.reclamos = reclamo;
	}
}
