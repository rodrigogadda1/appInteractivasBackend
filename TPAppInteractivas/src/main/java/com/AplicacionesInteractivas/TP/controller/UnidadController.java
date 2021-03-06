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
import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Foto;
import com.AplicacionesInteractivas.TP.entity.Reclamo;
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
		List<Unidad> unidades = this.unidadRepository.findAll();
		for (int i = 0; i < unidades.size(); i++) {
			Unidad unidad = unidades.get(i);	
			unidades.set(i, cleanUnidad(unidad));
	}
		return unidades;
	}
	//get unidad By ID
	@GetMapping("/{id}")
	public Unidad getUnidadById(@PathVariable (value="id") long unidadId) {
		Unidad unidad = this.unidadRepository.findById(unidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Unidad not fount whth ID" + unidadId));
		return cleanUnidad(unidad);
	}
	
	//delete unidad by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Unidad>  deleteUnidadById(@PathVariable (value="id") long unidadId) {
		Unidad unidExisting = this.unidadRepository.findById(unidadId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Unidad para eliminar" +unidadId));
		this.unidadRepository.delete(unidExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Foto by ID
	@PutMapping("/{id}")
	public Unidad updateUnidadById(@RequestBody Unidad unidad, @PathVariable (value="id") long unidadId) {
		Unidad unidadActual = this.unidadRepository.findById(unidadId)
				.orElseThrow(() -> new ResourceNotFoundException("Unidad not fount whth ID" + unidadId));
		if (unidad.getPiso() != null) {
			unidadActual.setPiso(unidad.getPiso());
		}
		
		if (unidad.getUnidad() != null) {
			unidadActual.setUnidad(unidad.getUnidad());
		}
		 		
		return cleanUnidad(this.unidadRepository.save(unidadActual));
	}
	
	private Unidad cleanUnidad (Unidad unidad) {
		if(unidad.getEdificio() != null) {
			Edificio edificio = unidad.getEdificio();
			
			edificio.setUnidades(null);
			edificio.setEspaciosComunes(null);
	
			edificio.setInspectores(null);
			
			
			unidad.setEdificio(edificio);	
		}

//		List<InspectorEdificio> inspectorEdificios = edificio.getInspectoredificio();
//		for (int i = 0; i < inspectorEdificios.size(); i++) {
//			InspectorEdificio inspectorEdificio = inspectorEdificios.get(i);
//			
//			inspectorEdificio.setInspector(null);
//			inspectorEdificio.setEdificio(null);
//			
//			inspectorEdificios.set(i, inspectorEdificio);
//		}
//		edificio.setInspectoredificio(inspectorEdificios);
		
//		List<InspectorEspecialidad> inspectorEspecialidades = edificio.getInspectorespecalidad();
//		for (int i = 0; i < inspectorEspecialidades.size(); i++) {
//			InspectorEspecialidad inspectorEspecialidad = inspectorEspecialidades.get(i);
//			
//			Inspector inspector = inspectorEspecialidad.getInspector();
//			inspector.setInspectoredificio(null);
//			inspector.setInspectorespecialidad(null);
//			inspectorEspecialidad.setInspector(inspector);
//			
//			inspectorEspecialidades.set(i, inspectorEspecialidad);
//		}
		//unidad.setEdificio(edificio);	
		
		/*List<AdministradoUnidad> administradoUnidades = unidad.getAdministradoUnidades();
		
		for (int i = 0; i < administradoUnidades.size(); i++) {
			AdministradoUnidad administradoUnidad = administradoUnidades.get(i);
			
			Administrado administrado = administradoUnidad.getAdministrado();
			administrado.setReclamo(null);
			
			administrado.setAdministradoUnidades(null);
			
			administradoUnidad.setAdministrado(administrado);
			
			administradoUnidad.setUnidad(null);
			
			administradoUnidades.set(i, administradoUnidad);
		}
		unidad.setAdministradoUnidades(administradoUnidades);*/
		
		return unidad;
	}

}
