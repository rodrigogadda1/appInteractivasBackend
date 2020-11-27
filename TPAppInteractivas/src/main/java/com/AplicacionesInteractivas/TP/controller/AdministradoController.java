package com.AplicacionesInteractivas.TP.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Foto;
import com.AplicacionesInteractivas.TP.entity.Notificacion;
import com.AplicacionesInteractivas.TP.entity.Reclamo;
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
	
////get administrado by id
	@GetMapping("/{id}")
	public Administrado getAdministradoById(@PathVariable (value = "id") long administradoId) {
		Administrado administrado = administradoRepository.findById(administradoId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ administradoId));
		return cleanAdministrado(administrado);
	}
	
	//create administrado
	@PostMapping
	public Administrado createAdministrado(@RequestBody Administrado administrado) {
		return this.administradoRepository.save(administrado);
	}
	
	//update Adminsitrado by ID
	@PutMapping("/{id}")
	public Administrado updateAdmninistradoById(@RequestBody Administrado administrado, @PathVariable (value="id") long administradoId) {
		Administrado adminiActual = this.administradoRepository.findById(administradoId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + administradoId));
		
		if (administrado.getId_user() != 0) {
			adminiActual.setId_user(administrado.getId_user());
		}
			
		return this.administradoRepository.save(adminiActual);
	}
	
	//delete Foto by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Administrado>  deleteAdministradoById(@PathVariable (value="id") long administradoId) {
		Administrado adminExisting = this.administradoRepository.findById(administradoId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Foto para eliminar" +administradoId));
		this.administradoRepository.delete(adminExisting);
		return ResponseEntity.ok().build();
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
			edificio.setInspectores(null);

			
			unidad.setEdificio(edificio);
			unidad.setAdministradoUnidades(null);
	
			
			administradoUnidad.setUnidad(unidad);
			
			administradoUnidades.set(i, administradoUnidad);
			

		}
		
		administrado.setAdministradoUnidades(administradoUnidades);
		
		List<Reclamo> reclamos= administrado.getReclamo();
		for (int j = 0; j < reclamos.size(); j++) {
			Reclamo reclamo = reclamos.get(j);
			reclamo.setAdministrado(null);
			
			/*Unidad unidad = reclamo.getUnidad();
			
			Edificio edificio = unidad.getEdificio();
			edificio.setEspaciosComunes(null);
			edificio.setUnidades(null);
			edificio.setInspectoredificio(null);
			edificio.setInspectorespecalidad(null);
			
			unidad.setEdificio(edificio);
			unidad.setAdministradoUnidades(null);
	
			reclamo.setUnidad(unidad);*/
			
			
			Edificio edificio2 = reclamo.getEdificio();
			
			edificio2.setUnidades(null);
			edificio2.setEspaciosComunes(null);
			edificio2.setInspectores(null);
			
			
			reclamo.setEdificio(edificio2);
			
			
			
			reclamos.set(j, reclamo);
		}
		administrado.setReclamo(reclamos);
		
		return administrado;
	}
	
}
