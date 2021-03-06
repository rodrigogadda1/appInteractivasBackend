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
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.EspacioComun;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.EspacioComunRepository;

@RestController 
@RequestMapping("api/espacioscomunes")
public class EspacioComunController {

	@Autowired
	private EspacioComunRepository espaciocomunRepository;
	
	//create espacioComun
	@PostMapping
	public EspacioComun createEspacioComun(@RequestBody EspacioComun espaciocomun) {
		return this.espaciocomunRepository.save(espaciocomun);
	}
	
	//get all EspacioComun
	@GetMapping
	public List<EspacioComun> getAllEspacioComun(){
		List<EspacioComun> espacios = this.espaciocomunRepository.findAll();
		for (int i = 0; i < espacios.size(); i++) {
			espacios.set(i, cleanEspacioComun(espacios.get(i)));
		}
		return espacios;
	}
	
	//get EspacioComun by id
	@GetMapping("/{id}")
	public EspacioComun getEspacioComunById(@PathVariable (value="id") long espaciocomunId) {
		EspacioComun espaciocomun = this.espaciocomunRepository.findById(espaciocomunId)
				.orElseThrow(() -> new ResourceNotFoundException("Especialiad not fount whth ID" + espaciocomunId));
		return cleanEspacioComun(espaciocomun);
	}
	//delete EspacioComun by id
	@DeleteMapping("/{id}")
	public ResponseEntity<EspacioComun>  deleteEspacioComunById(@PathVariable (value="id") long espaciocomunId) {
		EspacioComun espExisting = this.espaciocomunRepository.findById(espaciocomunId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe especialidad para eliminar" +espaciocomunId));
		this.espaciocomunRepository.delete(espExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Adminsitrado by ID
	@PutMapping("/{id}")
	public EspacioComun updateEspacioComunById(@RequestBody EspacioComun espacioComun, @PathVariable (value="id") long espcomId) {
		EspacioComun espComunActual = this.espaciocomunRepository.findById(espcomId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + espcomId));
		
		if (espacioComun.getDescripcion() != null) {
			espComunActual.setDescripcion(espacioComun.getDescripcion());
		}
			
		if (espacioComun.getNombre() != null) {
			espComunActual.setNombre(espacioComun.getNombre());
		}
		return this.espaciocomunRepository.save(espComunActual);
	}
	
	private EspacioComun cleanEspacioComun (EspacioComun espaciocomun) {
		if (espaciocomun.getEdificio() != null) {
			Edificio edificio = espaciocomun.getEdificio();
			edificio.setUnidades(null);
			edificio.setEspaciosComunes(null);
			edificio.setInspectores(null);
			
			espaciocomun.setEdificio(edificio);
		}
		return espaciocomun;
	}
	
}
