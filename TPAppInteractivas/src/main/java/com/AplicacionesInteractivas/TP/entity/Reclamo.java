package com.AplicacionesInteractivas.TP.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//creacion de JPA entity Reclamos
@Entity
@Table(name="reclamos")
public class Reclamo {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id_reclamo;
		
		@Column(name = "nombre")
		private String Nombre;
		
		@Column(name="username")
		private String username;
		
		@Column(name="id_edificio")
		private long idEdificio;
		
		@Column(name="id_especialidad")
		private long idEspecialidad;
		
		@Column(name="fecha")
		private Date fecha;
		
		@OneToOne
		@JoinColumn(name="id_estado")
		private Estado estado;
		
		@Column(name="id_agrupador")
		private long idAgrupador;
		
		@Column(name="descripcion")
		private String descripcion;
		
		public Reclamo() {
			super();
		}

		public Reclamo(long id_reclamo, String nombre, String username, long idEdificio, long idEspecialidad,
				Date fecha, Estado estado, long idAgrupador, String descripcion) {
			super();
			this.id_reclamo = id_reclamo;
			Nombre = nombre;
			this.username = username;
			this.idEdificio = idEdificio;
			this.idEspecialidad = idEspecialidad;
			this.fecha = fecha;
			this.estado = estado;
			this.idAgrupador = idAgrupador;
			this.descripcion = descripcion;
		}

		@Override
		public String toString() {
			return "Reclamo [id_reclamo=" + id_reclamo + ", Nombre=" + Nombre + ", username=" + username
					+ ", idEdificio=" + idEdificio + ", idEspecialidad=" + idEspecialidad + ", fecha=" + fecha
					+ ", estado=" + estado + ", idAgrupador=" + idAgrupador + ", descripcion=" + descripcion + "]";
		}

		public long getId_reclamo() {
			return id_reclamo;
		}

		public void setId_reclamo(long id_reclamo) {
			this.id_reclamo = id_reclamo;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public long getIdEdificio() {
			return idEdificio;
		}

		public void setIdEdificio(long idEdificio) {
			this.idEdificio = idEdificio;
		}

		public long getIdEspecialidad() {
			return idEspecialidad;
		}

		public void setIdEspecialidad(long idEspecialidad) {
			this.idEspecialidad = idEspecialidad;
		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}

		public long getIdAgrupador() {
			return idAgrupador;
		}

		public void setIdAgrupador(long idAgrupador) {
			this.idAgrupador = idAgrupador;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
}
