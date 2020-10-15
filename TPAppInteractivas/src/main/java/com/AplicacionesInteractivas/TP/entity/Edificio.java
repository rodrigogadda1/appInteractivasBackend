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
@Table(name="edificios")
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="CantUnidades")
	private long cantUnidades;
	
	@OneToMany
	@JoinColumn(name="id_edificio", nullable = true)
	private List<Unidad> unidades;
		
	@OneToMany
	@JoinColumn(name="id_edificio", nullable = true)
	private List<EspacioComun> espaciosComunes;

	public Edificio() {
		super ();
	}
	public Edificio(long id,String nombre, String direccion, String telefono, long cantUnidades, List<Unidad> unidades,
			List<EspacioComun> espaciosComunes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cantUnidades = cantUnidades;
		this.unidades = unidades;
		this.espaciosComunes = espaciosComunes;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public long getCantUnidades() {
		return cantUnidades;
	}
	public void setCantUnidades(long cantUnidades) {
		this.cantUnidades = cantUnidades;
	}
	public List<Unidad> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidad> unidades) {
		this.unidades = unidades;
	}
	public List<EspacioComun> getEspaciosComunes() {
		return espaciosComunes;
	}
	public void setEspaciosComunes(List<EspacioComun> espaciosComunes) {
		this.espaciosComunes = espaciosComunes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Edificio [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", cantUnidades=" + cantUnidades + ", unidades=" + unidades + ", espaciosComunes=" + espaciosComunes.toString()
				+ "]";
	}
	
	
		
}
