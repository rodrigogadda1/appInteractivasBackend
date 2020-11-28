package com.AplicacionesInteractivas.TP.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.repository.AdministradoUnidadRepository;
import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.AdministradoUnidad;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;

@RestController 
@RequestMapping("api/administrados/unidades")
public class AdministradoUnidadController {

	 @Autowired
	private AdministradoUnidadRepository administradoUnidadRepository;
	
	@GetMapping
	public List<AdministradoUnidad> getAllAdministradosUnidaddes(){
		List<AdministradoUnidad> lista=  this.administradoUnidadRepository.findAll();
		for (int i = 0; i < lista.size(); i++) {
			AdministradoUnidad administradoUnidad = lista.get(i);
			lista.set(i, cleanAdministradoUnidad(administradoUnidad));
			
		}
		return lista;
	}
	
//get administradounidad by id
	@GetMapping("/{id}")
	public AdministradoUnidad getAdministradoUnidadById(@PathVariable (value = "id") long adminunidId) {
		AdministradoUnidad administradoUnidad = administradoUnidadRepository.findById(adminunidId)
				.orElseThrow(() -> new ResourceNotFoundException("AdministradoUnidad not found with id:"+ adminunidId));
		return cleanAdministradoUnidad(administradoUnidad);
	}
	
	//create administradoUnidad
	@PostMapping
	public AdministradoUnidad createAdministradoUnidad(@RequestBody AdministradoUnidad administradoUnidad) {
		return this.administradoUnidadRepository.save(administradoUnidad);
	}	
	
	//update AdminsitradoUnidad by ID
	@PutMapping("/{id}")
	public AdministradoUnidad updateAdmninistradoUnidadById(@RequestBody AdministradoUnidad administradoUnidad, @PathVariable (value="id") long adminunidId) {
		AdministradoUnidad adminiActual = this.administradoUnidadRepository.findById(adminunidId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + adminunidId));
		
		if (administradoUnidad.getRelacion() != null) {
			adminiActual.setRelacion(administradoUnidad.getRelacion());
		}
		
		//if (administradoUnidad.getAdministrado() != null) {
			//adminiActual.setAdministrado(administradoUnidad.getAdministrado());
		//}
		
		if (administradoUnidad.getUnidad() != null) {
			adminiActual.setUnidad(administradoUnidad.getUnidad());
		}
		return cleanAdministradoUnidad(this.administradoUnidadRepository.save(adminiActual));
	}
	
	//delete AdministradoUnidad by id
	@DeleteMapping("/{id}")
	public ResponseEntity<AdministradoUnidad>  deleteAdministradoUnidadById(@PathVariable (value="id") long adminunidId) {
		AdministradoUnidad adminExisting = this.administradoUnidadRepository.findById(adminunidId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Foto para eliminar" +adminunidId));
		this.administradoUnidadRepository.delete(adminExisting);
		return ResponseEntity.ok().build();
	}
	//get all Unidades By id_administrado
	@GetMapping("/getByAdministradoId")
	public List<Unidad> getAllUnidadesByAdministradoID(@RequestParam("id") long adminstradoId){
		List<AdministradoUnidad> AllAdministradosUnidades = this.administradoUnidadRepository.findAll(); //todos los adminstradosunidades
		List<Unidad> unidadesResult = new ArrayList<Unidad>(); //lista de unidades resultantes que tienen el id administrado
		AdministradoUnidad administradounidad=null;
		
		if (AllAdministradosUnidades.size() > 0){
			for (int i = 0; i < AllAdministradosUnidades.size(); i++) {
				administradounidad=AllAdministradosUnidades.get(i);
				if(administradounidad.getId()==adminstradoId) {
					
					unidadesResult.add(administradounidad.getUnidad());
				}
			}
		}
				
		return unidadesResult;
	}
	
	private AdministradoUnidad cleanAdministradoUnidad(AdministradoUnidad administradoUnidad) {
		Administrado admin = null; 
				//administradoUnidad.getAdministrado();
		//admin.setAdministradoUnidades(null);
		/*admin.setReclamo(null);
		administradoUnidad.setAdministrado(admin);
		
		Unidad unidad = administradoUnidad.getUnidad();
		//unidad.setAdministradoUnidades(null);
		
		Edificio edificio = unidad.getEdificio();
		edificio.setUnidades(null);
		edificio.setEspaciosComunes(null);
		edificio.setInspectores(null);
		

		
		unidad.setEdificio(edificio);
		
		administradoUnidad.setUnidad(unidad);*/
		
		return administradoUnidad;
	}
	
}
