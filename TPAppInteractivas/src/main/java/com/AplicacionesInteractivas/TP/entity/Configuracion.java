package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="configuraciones")
public class Configuracion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_configuracion;
	
	@Column(name="datos_moviles")
	private boolean datos_moviles;
	
	@Column(name="recibir_notificaciones")
	private boolean recibir_notificaciones;

	

	@Override
	public String toString() {
		return "Configuracion [id_configuracion=" + id_configuracion + ", datos_moviles=" + datos_moviles
				+ ", recibir_notificaciones=" + recibir_notificaciones + "]";
	}

	public Configuracion() {
		super();
	}

	public Configuracion(long id_configuracion, boolean datos_moviles, boolean recibir_notificaciones) {
		super();
		this.id_configuracion = id_configuracion;
		this.datos_moviles = datos_moviles;
		this.recibir_notificaciones = recibir_notificaciones;
	}

	public long getId_configuracion() {
		return id_configuracion;
	}

	public void setId_configuracion(long id_configuracion) {
		this.id_configuracion = id_configuracion;
	}

	public boolean isDatos_moviles() {
		return datos_moviles;
	}

	public void setDatos_moviles(boolean datos_moviles) {
		this.datos_moviles = datos_moviles;
	}

	public boolean isRecibir_notificaciones() {
		return recibir_notificaciones;
	}

	public void setRecibir_notificaciones(boolean recibir_notificaciones) {
		this.recibir_notificaciones = recibir_notificaciones;
	}
	
}
