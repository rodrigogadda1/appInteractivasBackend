package com.AplicacionesInteractivas.TP.entity;

import java.sql.Blob;

public class FotoFront {
	private long id_foto;
	private String foto;
	
	public FotoFront() {
		super();
	}

	public FotoFront(long id_foto, String foto) {
		super();
		this.id_foto = id_foto;
		this.foto = foto;
	}
	
	public long getId_foto() {
		return id_foto;
	}

	public void setId_foto(long id_foto) {
		this.id_foto = id_foto;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
