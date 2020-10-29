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
import com.AplicacionesInteractivas.TP.entity.Inspector;
import com.AplicacionesInteractivas.TP.entity.InspectorEdificio;
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
		return this.edificioRepository.save(edificio);
	}
	
	//get all Edificios
	/*
	 * @GetMapping public List<Edificio> getAllEdificio(){ return
	 * this.edificioRepository.findAll(); }
	 */
		@GetMapping
		public List<Edificio> getAllEdificio(){
			List<Edificio> edificios =  this.edificioRepository.findAll();
			for (int i = 0; i < edificios.size(); i++) {
				Edificio edificio = edificios.get(i);
				List<Unidad> unidades = edificio.getUnidades();
				for (int j = 0; j < unidades.size(); j++) {
					Unidad unidad = unidades.get(j);
					unidad.setEdificio(null);
					unidades.set(j, unidad);
				}
				edificio.setUnidades(unidades);
				List<EspacioComun> espacios = edificio.getEspaciosComunes();
				for (int j = 0; j < espacios.size(); j++) {
					EspacioComun espacio = espacios.get(j);
					espacio.setEdificio(null);
					espacios.set(j, espacio);
				}
				edificio.setEspaciosComunes(espacios);
				
				List<InspectorEdificio> inspectoredificios = edificio.getInspectoredificio();
				for (int j = 0; j < inspectoredificios.size(); j++) {
					InspectorEdificio inspectoredificio=inspectoredificios.get(j);
					inspectoredificio.setEdificio(null);
					Inspector inspector=inspectoredificio.getInspector();
					inspector.setInspectoredificio(null);
					inspectoredificio.setInspector(inspector);
					inspectoredificios.set(j, inspectoredificio);
				}
				
				edificio.setInspectoredificio(inspectoredificios);
				edificios.set(i, edificio);
				
			
				
			}
			return edificios;
		}	
		
//		@GetMapping("/{id}")
//		public Edificio getEdificioById(@PathVariable (value="id") long edificioId) {
//			
//			return this.edificioRepository.findById(edificioId)
//					.orElseThrow(() -> new ResourceNotFoundException("Edificio not fount whth ID" + edificioId));
//		}
		
	public Edificio getEdificioById(@PathVariable (value="id") long edificioId) {
		Edificio edificio =
		 this.edificioRepository.findById(edificioId)
				.orElseThrow(() -> new ResourceNotFoundException("Edificio not fount whth ID" + edificioId));
		List<EspacioComun> espacios = edificio.getEspaciosComunes();
		for (int i = 0; i < espacios.size(); i++) {
			EspacioComun espacio = espacios.get(i);
			espacio.setEdificio(null);
			espacios.set(i, espacio);
		}
		edificio.setEspaciosComunes(espacios);
		List<Unidad> unidades = edificio.getUnidades();
		for (int i = 0; i < unidades.size(); i++) {
			Unidad unidad = unidades.get(i);
			unidad.setEdificio(null);
			unidades.set(i, unidad);
		}
		edificio.setUnidades(unidades);
		return edificio;
		}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Edificio>  deleteEdificioById(@PathVariable (value="id") long edificioId) {
		Edificio edifExisting = this.edificioRepository.findById(edificioId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Edificio para eliminar" +edificioId));
		this.edificioRepository.delete(edifExisting);
		return ResponseEntity.ok().build();
	}
	
	
}
