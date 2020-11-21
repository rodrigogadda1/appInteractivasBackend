package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="notificaciones")
public class Notificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_notificacion;
	
	//@OneToOne
	//@JoinColumn(name="id_idnotificacion")
	@Column(name="id_administrado")
	private int id_administrdo;
	
	//@OneToOne
	//@JoinColumn(name="id_reclamo")
	@Column(name="id_reclamo")
	private int id_reclamo;
	
	@Column(name="descripcion")
	private String descripcion;
	//id_administrado , id_reclamo, descripcion y status (o leido)
	
	@Column(name="leido")
	private boolean leido;

	public Notificacion() {
		super();
	}

	public Notificacion(long id_notificacion, int id_administrdo, int id_reclamo, String descripcion, boolean leido) {
		super();
		this.id_notificacion = id_notificacion;
		this.id_administrdo = id_administrdo;
		this.id_reclamo = id_reclamo;
		this.descripcion = descripcion;
		this.leido = leido;
	}

	@Override
	public String toString() {
		return "Notificacion [id_notificacion=" + id_notificacion + ", id_administrdo=" + id_administrdo
				+ ", id_reclamo=" + id_reclamo + ", descripcion=" + descripcion + ", leido=" + leido + "]";
	}

	public long getId_notificacion() {
		return id_notificacion;
	}

	public void setId_notificacion(long id_notificacion) {
		this.id_notificacion = id_notificacion;
	}

	public int getId_administrdo() {
		return id_administrdo;
	}

	public void setId_administrdo(int id_administrdo) {
		this.id_administrdo = id_administrdo;
	}

	public int getId_reclamo() {
		return id_reclamo;
	}

	public void setId_reclamo(int id_reclamo) {
		this.id_reclamo = id_reclamo;
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
