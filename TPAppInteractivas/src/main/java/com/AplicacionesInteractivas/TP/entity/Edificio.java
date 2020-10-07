package com.AplicacionesInteractivas.TP.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="edificios")
public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="CantUnidades")
	private long cantUnidades;
	
	@Column(name="unidades")
	@OneToMany(mappedBy="id")
	private List<Unidad> unidades;
		
	@Column(name="espaciosComunes")
	@OneToMany(mappedBy="id")
	private List<EspacioComun> espaciosComunes;

	public Edificio() {
		super ();
	}
	public Edificio(long id, String direccion, String telefono, long cantUnidades, List<Unidad> unidades,
			List<EspacioComun> espaciosComunes) {
		super();
		this.id = id;
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
		
}
