package com.AplicacionesInteractivas.TP.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name ="fotos")
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_foto;
	
	@Lob
	@Column (name = "foto")
	private Byte[] foto;

	public Foto() {
		super();
	}

	public Foto(long id_foto, Byte[] foto) {
		super();
		this.id_foto = id_foto;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Foto [id_foto=" + id_foto + ", foto=" + Arrays.toString(foto) + "]";
	}

	public long getId_foto() {
		return id_foto;
	}

	public void setId_foto(long id_foto) {
		this.id_foto = id_foto;
	}

	public Byte[] getFoto() {
		return foto;
	}

	public void setFoto(Byte[] foto) {
		this.foto = foto;
	}


}
