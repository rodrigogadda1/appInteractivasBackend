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
import com.AplicacionesInteractivas.TP.entity.Inspector;
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
	
	@GetMapping
	public List<Edificio> getAllEdificio(){
		List<Edificio> edificios =  this.edificioRepository.findAll();
		for (int i = 0; i < edificios.size(); i++) {
			edificios.set(i, cleanEdificio(edificios.get(i)));
		}
		return edificios;
		}	
	
	@GetMapping("/{id}")
	public Edificio getEdificioById(@PathVariable (value="id") long edificioId) {
		Edificio edificio =
		 this.edificioRepository.findById(edificioId)
				.orElseThrow(() -> new ResourceNotFoundException("Edificio not fount whth ID" + edificioId));
		return cleanEdificio(edificio);
		}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Edificio>  deleteEdificioById(@PathVariable (value="id") long edificioId) {
		Edificio edifExisting = this.edificioRepository.findById(edificioId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Edificio para eliminar" +edificioId));
		this.edificioRepository.delete(edifExisting);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public Edificio updateEdificioById(@RequestBody Edificio edificio, @PathVariable (value="id") long edificioId) {
		Edificio adificioActual = this.edificioRepository.findById(edificioId)
				.orElseThrow(() -> new ResourceNotFoundException("Edificio not fount whth ID" + edificioId));
		
		if (edificio.getCantUnidades() != 0) {
			adificioActual.setCantUnidades(edificio.getCantUnidades());
		}
			
		if (edificio.getDireccion() != null) {
			adificioActual.setDireccion(edificio.getDireccion());
		}
		
		if (edificio.getNombre() != null) {
			adificioActual.setNombre(edificio.getNombre());
		}
		
		if (edificio.getTelefono() != null) {
			adificioActual.setTelefono(edificio.getTelefono());
		}
		return cleanEdificio(this.edificioRepository.save(adificioActual));
	}
	
	private Edificio cleanEdificio(Edificio edificio) {
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
		
		List<Inspector> inspectores = edificio.getInspectores();
		for (int j = 0; j < inspectores.size(); j++) {
			Inspector inspector=inspectores.get(j);
			inspector.setEspecialidades(null);
			
//			Inspector inspector=inspectoredificio.getInspector();
//			inspector.setInspectoredificio(null);
//			inspector.setInspectorespecialidad(null);
//			inspectoredificio.setInspector(inspector);
			
			inspectores.set(j, inspector);
		}
		
		edificio.setInspectores(inspectores);
		/*List<InspectorEspecialidad> inspectorEspecialidades = edificio.getInspectorespecalidad();
		for (int i = 0; i < inspectorEspecialidades.size(); i++) {
			InspectorEspecialidad inspectorEspecialidad = inspectorEspecialidades.get(i);
			
			Inspector inspector = inspectorEspecialidad.getInspector();
			inspector.setInspectoredificio(null);
			
			List<InspectorEspecialidad> inspectorEspecialidades2 = inspector.getInspectorespecialidad();
			if (inspectorEspecialidades2 != null) {
				for (int j = 0; j < inspectorEspecialidades2.size(); j++) {
					InspectorEspecialidad inspectorEspecialidad2 = inspectorEspecialidades2.get(j);
					
					inspectorEspecialidad2.setInspector(null);
					
					inspectorEspecialidades2.set(j, inspectorEspecialidad2);
				}
				inspector.setInspectorespecialidad(inspectorEspecialidades2);
			}
			inspectorEspecialidad.setInspector(inspector);
			
			
			
			inspectorEspecialidades.set(i, inspectorEspecialidad);
		}
		*/
		//edificio.setInspectorespecalidad(inspectorEspecialidades);
		
		//edificio.setInspectoredificio(inspectoredificios);
		
		return edificio;
	}
	
	
}