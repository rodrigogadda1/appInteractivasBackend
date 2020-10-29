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
			EspacioComun espaciocomun = espacios.get(i);
			Edificio edificio = espaciocomun.getEdificio();
			edificio.setUnidades(null);
			edificio.setEspaciosComunes(null);
			espaciocomun.setEdificio(edificio);
			espacios.set(i, espaciocomun);
		}
		return espacios;
	}
	
	//get EspacioComun by id
	@GetMapping("/{id}")
	public EspacioComun getEspacioComunById(@PathVariable (value="id") long espaciocomunId) {
		
		EspacioComun espaciocomun = this.espaciocomunRepository.findById(espaciocomunId)
				.orElseThrow(() -> new ResourceNotFoundException("Especialiad not fount whth ID" + espaciocomunId));
		Edificio edificio = espaciocomun.getEdificio();
		edificio.setUnidades(null);
		edificio.setEspaciosComunes(null);
		espaciocomun.setEdificio(edificio);
		return espaciocomun;
	}
	//delete EspacioComun by id
	@DeleteMapping("/{id}")
	public ResponseEntity<EspacioComun>  deleteEspacioComunById(@PathVariable (value="id") long espaciocomunId) {
		EspacioComun espExisting = this.espaciocomunRepository.findById(espaciocomunId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe especialidad para eliminar" +espaciocomunId));
		this.espaciocomunRepository.delete(espExisting);
		return ResponseEntity.ok().build();
	}
}
