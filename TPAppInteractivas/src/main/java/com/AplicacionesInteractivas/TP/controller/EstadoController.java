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

import com.AplicacionesInteractivas.TP.entity.Estado;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.EstadoRepository;

@RestController 
@RequestMapping("api/estados")
public class EstadoController {
	@Autowired
	private EstadoRepository estadoRepository;
	
	//create Estado
	@PostMapping
	public Estado createEstado(@RequestBody Estado estado) {
		return this.estadoRepository.save(estado);
	}
	//get all Estado
	@GetMapping
	public List<Estado> getAllEstado(){
		List<Estado> estados = this.estadoRepository.findAll();
//		for (int i = 0; i < estados.size(); i++) {
//			estados.set(i, cleanEstado(estados.get(i)));
//		}
		return estados;
	}
	//get Estado by id
	@GetMapping("/{id}")
	public Estado getEstadoById(@PathVariable (value="id") long estadoId) {
		Estado estado = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Estado not fount whth ID" + estadoId));
		return estado;
	}
	
	//delete Estado by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Estado>  deleteEstadoById(@PathVariable (value="id") long estadoId) {
		Estado estExisting = this.estadoRepository.findById(estadoId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Estado para eliminar" +estadoId));
		this.estadoRepository.delete(estExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Estado by ID
	@PutMapping("/{id}")
	public Estado updateEstadoById(@RequestBody Estado estado, @PathVariable (value="id") long estadoId) {
		Estado estActual = this.estadoRepository.findById(estadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Especialidad not fount whth ID" + estadoId));
		
		if (estado.getDescripcion() != null) {
			estActual.setDescripcion(estado.getDescripcion());
		}
					
		return this.estadoRepository.save(estActual);
	}
//	private Estado cleanEstado (Estado estado) {
////		Edificio edificio = espaciocomun.getEdificio();
////		edificio.setUnidades(null);
////		edificio.setEspaciosComunes(null);
////		espaciocomun.setEdificio(edificio);
//		
//		return estado;
//	}
}

