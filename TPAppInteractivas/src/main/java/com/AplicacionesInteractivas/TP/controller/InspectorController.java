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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Inspector;
import com.AplicacionesInteractivas.TP.entity.InspectorEdificio;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.InspectorRepository;

@RestController 
@RequestMapping("api/inspectores")
public class InspectorController {
	
	@Autowired
	private InspectorRepository inspectorRepository;
	
	//create Inspector
	@PostMapping
	public Inspector createInspector(@RequestBody Inspector inspector) {
		return this.inspectorRepository.save(inspector);
	}
	
	//get all Inspectores
//	@GetMapping
//	public List<Inspector> getAllInspectores(){
//		return this.inspectorRepository.findAll();
//	}

	@GetMapping
	public List<Inspector> getAllInspectores(){
		List<Inspector> inspectores = this.inspectorRepository.findAll();
		for (int i = 0; i < inspectores.size(); i++) {
			Inspector inspector= inspectores.get(i);
			List<InspectorEdificio> inspectoresEdificios= inspector.getInspectoredificio();
			for (int j = 0; j < inspectoresEdificios.size(); j++) {
				InspectorEdificio inspectorEdificio=inspectoresEdificios.get(j);
				inspectorEdificio.setInspector(null);
				
				Edificio edificio = inspectorEdificio.getEdificio();
				edificio.setUnidades(null);
				edificio.setInspectoredificio(null);
				edificio.setEspaciosComunes(null);
				inspectorEdificio.setEdificio(edificio);
				
				inspectoresEdificios.set(j, inspectorEdificio);
			}
			
		
			inspector.setInspectoredificio(inspectoresEdificios);
		}
		
		return inspectores;
	}

	
	@GetMapping("/getId")
	public Inspector getInspectorByUserId(@RequestParam("id_user") long id_user) {
		List<Inspector> inspectores = this.inspectorRepository.findAll();
		int temp = 0;
		Inspector seleccionado = null;
		while ( (temp < inspectores.size()) && (seleccionado == null) ) {
			Inspector inspector = inspectores.get(temp);
			if (inspector.getId_user() == id_user) {
				seleccionado = inspector;
			}
		}
		if (seleccionado != null) {
			List<InspectorEdificio> inspectoredificios =  seleccionado.getInspectoredificio();
			for (int i = 0; i < inspectoredificios.size(); i++) {
				InspectorEdificio inspectorEdificio = inspectoredificios.get(i);
				
				inspectorEdificio.setInspector(null);
				
				Edificio edificio = inspectorEdificio.getEdificio();
				edificio.setEspaciosComunes(null);
				edificio.setUnidades(null);
				edificio.setInspectoredificio(null);
				inspectorEdificio.setEdificio(edificio);
				
				inspectoredificios.set(i, inspectorEdificio);
			}
			seleccionado.setInspectoredificio(inspectoredificios);
		}
		
		return seleccionado;
	}
	
	//get Inspector by id
	@GetMapping("/{id}")
	public Inspector getInspectorById(@PathVariable (value="id") long inspectorID) {
		Inspector inspector = this.inspectorRepository.findById(inspectorID)
				.orElseThrow(() -> new ResourceNotFoundException("Inspector not fount whth ID" + inspectorID));
		return inspector;
	}
	
	//delete Inspector by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Inspector>  deleteInspectorById(@PathVariable (value="id") long inspectorID) {
		Inspector inspExisting = this.inspectorRepository.findById(inspectorID)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Inspector para eliminar" +inspectorID));
		this.inspectorRepository.delete(inspExisting);
		return ResponseEntity.ok().build();
	}
}
