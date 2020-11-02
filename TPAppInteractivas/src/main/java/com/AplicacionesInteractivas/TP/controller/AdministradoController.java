package com.AplicacionesInteractivas.TP.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.AdministradoRepository;


@RestController 
@RequestMapping("api/administrados")
public class AdministradoController {
	
	@Autowired
	private AdministradoRepository administradoRepository;
	
	@GetMapping
	public List<Administrado> getAllAdministrados(){
		List<Administrado> administrados = this.administradoRepository.findAll();
		for (int i = 0; i < administrados.size(); i++) {
			administrados.set(i, cleanAdministrado(administrados.get(i)));
		}
		
		return administrados;
	}
	
	@GetMapping("/getId")
	public Administrado getAdministradoByUserId(@RequestParam("id_user") long id_user) {
		List<Administrado> administrados = this.administradoRepository.findAll();
		int temp = 0;
		long seleccionado = -1;
		while ((seleccionado == -1) && (temp < administrados.size())) {
			Administrado administrado = administrados.get(temp);
			if (administrado.getId_user() == id_user) {
				seleccionado = administrado.getId_administrado();
			}else {
				temp++;
			}
		}
		if (seleccionado == -1) {
			return null;
		} else {
			Administrado administrado = administradoRepository.findById(seleccionado)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ id_user));
			return cleanAdministrado(administrado);
		}
	}
	
////get user by id
	@GetMapping("/{id}")
	public Administrado getAdministradoId(@PathVariable (value = "id") long administradoId) {
		Administrado administrado = administradoRepository.findById(administradoId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ administradoId));
		return cleanAdministrado(administrado);
	}
	
	//create user
	@PostMapping
	public Administrado createUser(@RequestBody Administrado administrado) {
		return this.administradoRepository.save(administrado);
	}
	
	
	private Administrado cleanAdministrado(Administrado administrado) {
		List<AdministradoUnidad> administradoUnidades = administrado.getAdministradoUnidades();
		for (int i = 0; i < administradoUnidades.size(); i++) {
			AdministradoUnidad administradoUnidad = administradoUnidades.get(i);
			administradoUnidad.setAdministrado(null);
			
			Unidad unidad = administradoUnidad.getUnidad();
			
			Edificio edificio = unidad.getEdificio();
			edificio.setEspaciosComunes(null);
			edificio.setUnidades(null);
			edificio.setInspectoredificio(null);
			edificio.setInspectorespecalidad(null);
			
			unidad.setEdificio(edificio);
			unidad.setAdministradoUnidades(null);
			administradoUnidad.setUnidad(unidad);
			
			administradoUnidades.set(i, administradoUnidad);
		}
		administrado.setAdministradoUnidades(administradoUnidades);
		return administrado;
	}
	
}
