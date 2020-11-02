package com.AplicacionesInteractivas.TP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="fotos")
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_foto;
	
	@Column(name = "uri")
	private String uri_foto;

	public Foto() {
		super();
	}

	public Foto(long id_foto, String uri_foto) {
		super();
		this.id_foto = id_foto;
		this.uri_foto = uri_foto;
	}

	@Override
	public String toString() {
		return "Foto [id_foto=" + id_foto + ", uri_foto=" + uri_foto + "]";
	}

	public long getId_foto() {
		return id_foto;
	}

	public void setId_foto(long id_foto) {
		this.id_foto = id_foto;
	}

	public String getUri_foto() {
		return uri_foto;
	}

	public void setUri_foto(String uri_foto) {
		this.uri_foto = uri_foto;
	}
}
