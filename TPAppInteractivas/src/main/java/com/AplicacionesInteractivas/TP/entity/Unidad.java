package com.AplicacionesInteractivas.TP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="unidades")
public class Unidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_unidad;
	
	@Column(name="piso")
	private String piso;
	
	@Column(name="unidad")
	private String unidad;
	
	@ManyToOne
	@JoinColumn(name="id_edificio", nullable = true)
	private Edificio edificio;
	
	@OneToMany
	@JoinColumn(name="id_administradounidad")
	private List<AdministradoUnidad> administradoUnidades;
	
	
	public Unidad() {
		super();
	}

	public Unidad(long id_unidad, String piso, String unidad, Edificio edificio,
			List<AdministradoUnidad> administradoUnidades) {
		super();
		this.id_unidad = id_unidad;
		this.piso = piso;
		this.unidad = unidad;
		this.edificio = edificio;
		this.administradoUnidades = administradoUnidades;
	}

	@Override
	public String toString() {
		return "Unidad [id_unidad=" + id_unidad + ", piso=" + piso + ", unidad=" + unidad + ", edificio=" + edificio
				+ ", administradoUnidades=" + administradoUnidades + ", reclamos=" + "]";
	}

	public long getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(long id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public List<AdministradoUnidad> getAdministradoUnidades() {
		return administradoUnidades;
	}

	public void setAdministradoUnidades(List<AdministradoUnidad> administradoUnidades) {
		this.administradoUnidades = administradoUnidades;
	}

}
