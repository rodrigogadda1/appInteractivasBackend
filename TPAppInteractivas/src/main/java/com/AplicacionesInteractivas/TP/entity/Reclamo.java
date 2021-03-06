package com.AplicacionesInteractivas.TP.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

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
		
		@CreationTimestamp
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name="fecha")
		private Date fecha;
		
		@OneToOne
		@JoinColumn(name="id_estado")
		private Estado estado;
		
		@Column(name="id_agrupador")
		private long id_agrupador;
		
		@Column(name="descripcion")
		private String descripcion;
		
		@Column(name="respuesta_inspector")
	    private String respuesta_inspector;
	    
		@Column(name="respuesta_administrador")
	    private String respuesta_administrador;
		
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
		
		@OneToMany(cascade = CascadeType.ALL,
		        orphanRemoval = true
			    )
		@JoinColumn(name="id_reclamo")
		private List<Foto> fotos;
		
		public Reclamo() {
			super();
		}

		public Reclamo(long id_reclamo, String nombre, String username, Edificio edificio, Especialidad especialidad,
				Date fecha, Estado estado, long id_agrupador, String descripcion, String respuesta_inspector,
				String respuesta_administrador, Administrado administrado, Unidad unidad, EspacioComun espacioComun,
				List<Foto> fotos) {
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
			this.respuesta_inspector = respuesta_inspector;
			this.respuesta_administrador = respuesta_administrador;
			this.administrado = administrado;
			this.unidad = unidad;
			this.espacioComun = espacioComun;
			this.fotos = fotos;
		}

		@Override
		public String toString() {
			return "Reclamo [id_reclamo=" + id_reclamo + ", Nombre=" + Nombre + ", username=" + username + ", edificio="
					+ edificio + ", especialidad=" + especialidad + ", fecha=" + fecha + ", estado=" + estado
					+ ", id_agrupador=" + id_agrupador + ", descripcion=" + descripcion + ", respuesta_inspector="
					+ respuesta_inspector + ", respuesta_administrador=" + respuesta_administrador + ", administrado="
					+ administrado + ", unidad=" + unidad + ", espacioComun=" + espacioComun + ", fotos=" + fotos + "]";
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

		public String getRespuesta_inspector() {
			return respuesta_inspector;
		}

		public void setRespuesta_inspector(String respuesta_inspector) {
			this.respuesta_inspector = respuesta_inspector;
		}

		public String getRespuesta_administrador() {
			return respuesta_administrador;
		}

		public void setRespuesta_administrador(String respuesta_administrador) {
			this.respuesta_administrador = respuesta_administrador;
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

		public EspacioComun getEspacioComun() {
			return espacioComun;
		}

		public void setEspacioComun(EspacioComun espacioComun) {
			this.espacioComun = espacioComun;
		}

		public List<Foto> getFotos() {
			return fotos;
		}

		public void setFotos(List<Foto> fotos) {
			this.fotos = fotos;
		}

}
