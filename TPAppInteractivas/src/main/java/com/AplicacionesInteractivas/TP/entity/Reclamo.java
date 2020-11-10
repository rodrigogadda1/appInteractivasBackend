package com.AplicacionesInteractivas.TP.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

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
		
		@ManyToOne
		private Edificio edificio;
		
		@ManyToOne
		private Especialidad especialidad;
		
		@Column(name="fecha")
		private Date fecha;
		
		@OneToOne
		@JoinColumn(name="id_estado")
		private Estado estado;
		
		@Column(name="id_agrupador")
		private long id_agrupador;
		
		@Column(name="descripcion")
		private String descripcion;
		
		@ManyToOne
		private Administrado administrado;
		
		@OneToOne
		@Nullable
		@JoinColumn(name="id_unidad")
		private Unidad unidad;
		
		@OneToOne
		@Nullable
		@JoinColumn(name="id_espaciocomun")
		private EspacioComun espacioComun;
		
		@OneToMany
		@JoinColumn(name="id_reclamo")
		private List<Foto> fotos;
		
		public Reclamo() {
			super();
		}

		public Reclamo(long id_reclamo, String nombre, String username, Edificio edificio, Especialidad especialidad,
				Date fecha, Estado estado, long id_agrupador, String descripcion, Administrado administrado,
				Unidad unidad, EspacioComun espacioComun, List<Foto> fotos) {
			super();
			this.id_reclamo = id_reclamo;
			Nombre = nombre;
			this.username = username;
			this.edificio = edificio;
			this.especialidad = especialidad;
			this.fecha = fecha;
			this.estado = estado;
			this.id_agrupador = id_agrupador;
			this.descripcion = descripcion;
			this.administrado = administrado;
			this.unidad = unidad;
			this.espacioComun = espacioComun;
			this.fotos = fotos;
		}

		@Override
		public String toString() {
			return "Reclamo [id_reclamo=" + id_reclamo + ", Nombre=" + Nombre + ", username=" + username + ", edificio="
					+ edificio + ", especialidad=" + especialidad + ", fecha=" + fecha + ", estado=" + estado
					+ ", id_agrupador=" + id_agrupador + ", descripcion=" + descripcion + ", administrado="
					+ administrado + ", unidad=" + unidad + ", espacioComun=" + espacioComun + ", fotos=" + fotos + "]";
		}

		public EspacioComun getEspacioComun() {
			return espacioComun;
		}

		public void setEspacioComun(EspacioComun espacioComun) {
			this.espacioComun = espacioComun;
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

		public Edificio getEdificio() {
			return edificio;
		}

		public void setEdificio(Edificio edificio) {
			this.edificio = edificio;
		}

		public Especialidad getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(Especialidad especialidad) {
			this.especialidad = especialidad;
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

		public long getId_agrupador() {
			return id_agrupador;
		}

		public void setId_agrupador(long id_agrupador) {
			this.id_agrupador = id_agrupador;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Administrado getAdministrado() {
			return administrado;
		}

		public void setAdministrado(Administrado administrado) {
			this.administrado = administrado;
		}

		public Unidad getUnidad() {
			return unidad;
		}

		public void setUnidad(Unidad unidad) {
			this.unidad = unidad;
		}

		public List<Foto> getFotos() {
			return fotos;
		}

		public void setFotos(List<Foto> fotos) {
			this.fotos = fotos;
		}


}
