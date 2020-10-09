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

import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.EdificioRepository;


@RestController 
@RequestMapping("api/edificios")
public class EdificioController {
	
	@Autowired
	private EdificioRepository edificioRepository;
	
	//create Edificio
	@PostMapping
	public Edificio createEdificio(@RequestBody Edificio edificio) {
		if(edificio.getUnidades().size() > 0) {
			UnidadController uc = new UnidadController();
			for (int i = 0; i < edificio.getUnidades().size(); i++) {
				Unidad newUnidad = uc.createUnidad(edificio.getUnidades().get(i));
				edificio.getUnidades().set(i, newUnidad);
			}
		}
		return this.edificioRepository.save(edificio);
	}
	
	//get all Edificios
		@GetMapping
		public List<Edificio> getAllEdificio(){
			return this.edificioRepository.findAll();
		}

	//get EspacioComun by id
	@GetMapping("/{id}")
	public Edificio getEdificioById(@PathVariable (value="id") long edificioId) {
		
		return this.edificioRepository.findById(edificioId)
				.orElseThrow(() -> new ResourceNotFoundException("Edificio not fount whth ID" + edificioId));
		}
	@DeleteMapping("/{id}")
	public ResponseEntity<Edificio>  deleteEdificioById(@PathVariable (value="id") long edificioId) {
		Edificio edifExisting = this.edificioRepository.findById(edificioId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Edificio para eliminar" +edificioId));
		this.edificioRepository.delete(edifExisting);
		return ResponseEntity.ok().build();
	}
}
