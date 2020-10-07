package com.AplicacionesInteractivas.TP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Especialidad;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.UnidadRepository;

@RestController 
@RequestMapping("api/unidades")
public class UnidadController {

	@Autowired
	private UnidadRepository unidadRepository;
	
	//create unidad
	@PostMapping
	public Unidad createUnidad(@RequestBody Unidad unidad) {
		return this.unidadRepository.save(unidad);
	}
	//get All unidades
	@GetMapping
	public List<Unidad> getAllUnidades(){
		return this.unidadRepository.findAll();
	}
	//get unidad By ID
	@GetMapping("/{id}")
	public Unidad getUnidadById(@PathVariable (value="id") long unidadId) {
		
		return this.unidadRepository.findById(unidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Unidad not fount whth ID" + unidadId));
	}
	//delete unidad by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Unidad>  deleteUnidadById(@PathVariable (value="id") long unidadId) {
		Unidad unidExisting = this.unidadRepository.findById(unidadId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Unidad para eliminar" +unidadId));
		this.unidadRepository.delete(unidExisting);
		return ResponseEntity.ok().build();
	}
	

}
