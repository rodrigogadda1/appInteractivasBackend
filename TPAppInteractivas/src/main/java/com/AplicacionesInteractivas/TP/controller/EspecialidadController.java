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

import com.AplicacionesInteractivas.TP.entity.EspacioComun;
import com.AplicacionesInteractivas.TP.entity.Especialidad;
import com.AplicacionesInteractivas.TP.entity.Inspector;
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
		List<Especialidad> especialidades = this.especialidadRepository.findAll();
		for (int i = 0; i < especialidades.size(); i++) {
			especialidades.set(i, cleanEspecialidad(especialidades.get(i)));
		}
		return especialidades;
	}
	
	//get especialidad by id
	@GetMapping("/{id}")
	public Especialidad getEspecialidadById(@PathVariable (value="id") long especialidadId) {
		
		return cleanEspecialidad(this.especialidadRepository.findById(especialidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Especialiad not fount whth ID" + especialidadId)));
	}
	//delete especialidad by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Especialidad>  deleteEspecialidadById(@PathVariable (value="id") long especialidadId) {
		Especialidad espExisting = this.especialidadRepository.findById(especialidadId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe especialidad para eliminar" +especialidadId));
		this.especialidadRepository.delete(espExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Especialidad by ID
	@PutMapping("/{id}")
	public Especialidad updateEspcialidadById(@RequestBody Especialidad especialidad, @PathVariable (value="id") long especialidadId) {
		Especialidad espActual = this.especialidadRepository.findById(especialidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + especialidadId));
		
		if (especialidad.getNombre() != null) {
			espActual.setNombre(especialidad.getNombre());
		}
			
		if (especialidad.getDescripcion() != null) {
			espActual.setDescripcion(especialidad.getDescripcion());
		}
		
		return this.especialidadRepository.save(espActual);
	}
	private Especialidad cleanEspecialidad(Especialidad especialidad) {
		List<Inspector> inspectores = especialidad.getInspectores();
		for (int i = 0; i < inspectores.size(); i++) {
			Inspector inspector = especialidad.getInspectores().get(i);
			inspector.setEspecialidades(null);
			inspector.setEdificios(null);
			inspectores.set(i, inspector);
		}
		especialidad.setInspectores(inspectores);
		
		
		return especialidad;
		
	}
	
}
