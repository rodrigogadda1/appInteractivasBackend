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
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.EspecialidadRepository;

@RestController 
@RequestMapping("api/especialidades")
public class EspecialidadController {
		
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	//create Especialidad
	@PostMapping
	public Especialidad createEspecialidad(@RequestBody Especialidad especialidad) {
		return this.especialidadRepository.save(especialidad);
	}
	
	//get all especialidades
	@GetMapping
	public List<Especialidad> getAllEspecialidades(){
		return this.especialidadRepository.findAll();
	}
	
	//get especialidad by id
	@GetMapping("/{id}")
	public Especialidad getEspecialidadById(@PathVariable (value="id") long especialidadId) {
		
		return this.especialidadRepository.findById(especialidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Especialiad not fount whth ID" + especialidadId));
	}
	//delete especialidad by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Especialidad>  deleteEspecialidadById(@PathVariable (value="id") long especialidadId) {
		Especialidad espExisting = this.especialidadRepository.findById(especialidadId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe especialidad para eliminar" +especialidadId));
		this.especialidadRepository.delete(espExisting);
		return ResponseEntity.ok().build();
	}
	
	//update especialidad -> Falta realizar, es necesaria?
}
