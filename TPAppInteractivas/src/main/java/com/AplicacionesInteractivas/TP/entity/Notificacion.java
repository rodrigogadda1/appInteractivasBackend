package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name ="notificaciones")
public class Notificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_notificacion;
	
	@OneToOne
	@JoinColumn(name="id_idnotificacion")
	private Administrado administrado;
	
	@OneToOne
	@JoinColumn(name="id_reclamo")
	private Reclamo reclamo;
	
	@Column(name="descripcion")
	private String descripcion;
	//id_administrado , id_reclamo, descripcion y status (o leido)
	
	@Column(name="leido")
	private boolean leido;

	public Notificacion() {
		super();
	}

	public Notificacion(long id_notificacion, Administrado administrado, Reclamo reclamo, String descripcion,
			boolean leido) {
		super();
		this.id_notificacion = id_notificacion;
		this.administrado = administrado;
		this.reclamo = reclamo;
		this.descripcion = descripcion;
		this.leido = leido;
	}

	@Override
	public String toString() {
		return "Notificacion [id_notificacion=" + id_notificacion + ", administrado=" + administrado + ", reclamo="
				+ reclamo + ", descripcion=" + descripcion + ", leido=" + leido + "]";
	}

	public long getId_notificacion() {
		return id_notificacion;
	}

	public void setId_notificacion(long id_notificacion) {
		this.id_notificacion = id_notificacion;
	}

	public Administrado getAdministrado() {
		return administrado;
	}

	public void setAdministrado(Administrado administrado) {
		this.administrado = administrado;
	}

	public Reclamo getReclamo() {
		return reclamo;
	}

	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}
	
	
}
