package com.AplicacionesInteractivas.TP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.repository.AdministradoUnidadRepository;
import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Unidad;

@RestController 
@RequestMapping("api/administrados/unidades")
public class AdministradoUnidadController {

	 @Autowired
	private AdministradoUnidadRepository administradoUnidadRepository;
	
	@GetMapping
	public List<AdministradoUnidad> getAllAdministradosUnidaddes(){
		List<AdministradoUnidad> lista=  this.administradoUnidadRepository.findAll();
		for (int i = 0; i < lista.size(); i++) {
			AdministradoUnidad administradoUnidad = lista.get(i);
			lista.set(i, cleanAdministradoUnidad(administradoUnidad));
			
		}
		return lista;
	}
	
	private AdministradoUnidad cleanAdministradoUnidad(AdministradoUnidad administradoUnidad) {
		Administrado admin = administradoUnidad.getAdministrado();
		admin.setAdministradoUnidades(null);
		administradoUnidad.setAdministrado(admin);
		
		Unidad unidad = administradoUnidad.getUnidad();
		unidad.setAdministradoUnidades(null);
		
		Edificio edificio = unidad.getEdificio();
		edificio.setUnidades(null);
		edificio.setEspaciosComunes(null);
		
		unidad.setEdificio(edificio);
		
		administradoUnidad.setUnidad(unidad);
		
		return administradoUnidad;
	}
	
}
