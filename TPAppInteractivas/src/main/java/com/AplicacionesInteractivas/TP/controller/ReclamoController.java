package com.AplicacionesInteractivas.TP.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.Reclamo;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.ReclamoRepository;

@RestController 
@RequestMapping("api/reclamos")

public class ReclamoController {
	
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	//ceate Reclamo
	@PostMapping
	public Reclamo createReclamo(@RequestBody Reclamo reclamo) {
		return cleanReclamo(this.reclamoRepository.save(reclamo));
	}
	//get all Reclamos
	@GetMapping
	public List<Reclamo> getAllReclamos(){
		List<Reclamo> reclamos = this.reclamoRepository.findAll();
		for (int i = 0; i < reclamos.size(); i++) {
			Reclamo reclamo = reclamos.get(i);	
			reclamos.set(i, cleanReclamo(reclamo));
		}
		return this.reclamoRepository.findAll();
	}
	//get Reclamo by Id
	@GetMapping("/{id}")
	public Reclamo getREclamoById(@PathVariable (value="id") long reclamoId) {
		Reclamo reclamo = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + reclamoId));
		return cleanReclamo(reclamo);
	}
	//delete Reclamo by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Reclamo>  deleteReclamoById(@PathVariable (value="id") long reclamoId) {
		Reclamo reclamExisting = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Reclamo para eliminar" +reclamoId));
		this.reclamoRepository.delete(reclamExisting);
		return ResponseEntity.ok().build();
	}
	//update Reclamo by ID
	@PutMapping("/{id}")
	public Reclamo updateREclamoById(@RequestBody Reclamo reclamo, @PathVariable (value="id") long reclamoId) {
		Reclamo reclamoActual = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + reclamoId));
		
		if (reclamo.getAdministrado() != null) {
			reclamoActual.setAdministrado(reclamo.getAdministrado());
		}
		
		if (reclamo.getDescripcion() != null) {
		reclamoActual.setDescripcion(reclamo.getDescripcion());
		}
		
		if (reclamo.getEstado() != null) {
			reclamoActual.setEstado(reclamo.getEstado());
		}
		
		if(reclamo.getFecha() != null) {
			reclamoActual.setFecha(reclamo.getFecha());
		}
		
		if (reclamo.getFotos() != null) {
			reclamoActual.setFotos(reclamo.getFotos());
		}
		
		if (reclamo.getId_agrupador() != 0) {
			reclamoActual.setId_agrupador(reclamo.getId_agrupador());
		}
		
		if (reclamo.getId_edificio() != 0) {
			reclamoActual.setId_edificio(reclamo.getId_edificio());
		}
		
		if (reclamo.getId_especialidad() != 0) {
			reclamoActual.setId_especialidad(reclamo.getId_especialidad());
		}
		
		if (reclamo.getNombre() != null) {
			reclamoActual.setNombre(reclamo.getNombre());
		}
		
		if (reclamo.getUnidad() != null) {
			reclamoActual.setUnidad(reclamo.getUnidad());
		}
		
		if (reclamo.getUsername() != null) {
			reclamoActual.setUsername(reclamo.getUsername());
		}
		
		
		return cleanReclamo(this.reclamoRepository.save(reclamoActual));
	}
	
	//Clean Reclamo
	private Reclamo cleanReclamo (Reclamo reclamo) {
		Administrado administrado = reclamo.getAdministrado();
		
		administrado.setAdministradoUnidades(null);
		administrado.setReclamo(null);
		reclamo.setAdministrado(administrado);
		
		Unidad unidad = reclamo.getUnidad();
		unidad.setEdificio(null);
		unidad.setAdministradoUnidades(null);
		unidad.setReclamos(null);
		
		reclamo.setUnidad(unidad);
		return reclamo;
	}
}
