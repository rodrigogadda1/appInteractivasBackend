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

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.Edificio;
import com.AplicacionesInteractivas.TP.entity.EspacioComun;
import com.AplicacionesInteractivas.TP.entity.Reclamo;
import com.AplicacionesInteractivas.TP.entity.Unidad;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.ReclamoRepository;

@RestController 
@RequestMapping("api/reclamos")

public class ReclamoController {
	
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	//ceate Reclamo
	@PostMapping
	public Reclamo createReclamo(@RequestBody Reclamo reclamo) {
		return cleanReclamo(this.reclamoRepository.save(reclamo));
	}
	//get all Reclamos
	@GetMapping
	public List<Reclamo> getAllReclamos(){
		List<Reclamo> reclamos = this.reclamoRepository.findAll();
		for (int i = 0; i < reclamos.size(); i++) {
			Reclamo reclamo = reclamos.get(i);	
			reclamos.set(i, cleanReclamo(reclamo));
		}
		return this.reclamoRepository.findAll();
	}
	//get Reclamo by Id
	@GetMapping("/{id}")
	public Reclamo getREclamoById(@PathVariable (value="id") long reclamoId) {
		Reclamo reclamo = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + reclamoId));
		return cleanReclamo(reclamo);
	}
	//delete Reclamo by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Reclamo>  deleteReclamoById(@PathVariable (value="id") long reclamoId) {
		Reclamo reclamExisting = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Reclamo para eliminar" +reclamoId));
		this.reclamoRepository.delete(reclamExisting);
		return ResponseEntity.ok().build();
	}
	//update Reclamo by ID
	@PutMapping("/{id}")
	public Reclamo updateREclamoById(@RequestBody Reclamo reclamo, @PathVariable (value="id") long reclamoId) {
		Reclamo reclamoActual = this.reclamoRepository.findById(reclamoId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamo not fount whth ID" + reclamoId));
		
		if (reclamo.getAdministrado() != null) {
			reclamoActual.setAdministrado(reclamo.getAdministrado());
		}
		
		if (reclamo.getDescripcion() != null) {
		reclamoActual.setDescripcion(reclamo.getDescripcion());
		}
		
		if (reclamo.getEstado() != null) {
			reclamoActual.setEstado(reclamo.getEstado());
		}
		
		if(reclamo.getFecha() != null) {
			reclamoActual.setFecha(reclamo.getFecha());
		}
		
		if (reclamo.getFotos() != null) {
			reclamoActual.setFotos(reclamo.getFotos());
		}
		
		if (reclamo.getId_agrupador() != 0) {
			reclamoActual.setId_agrupador(reclamo.getId_agrupador());
		}
		
		if (reclamo.getEdificio() != null) {
			reclamoActual.setEdificio(reclamo.getEdificio());
		}
		
		if (reclamo.getEspecialidad() != null) {
			reclamoActual.setEspecialidad(reclamo.getEspecialidad());
		}
		
		if (reclamo.getNombre() != null) {
			reclamoActual.setNombre(reclamo.getNombre());
		}
		
		if (reclamo.getUnidad() != null) {
			reclamoActual.setUnidad(reclamo.getUnidad());
		}
		
		if (reclamo.getUsername() != null) {
			reclamoActual.setUsername(reclamo.getUsername());
		}
		if (reclamo.getRespuesta_administrador() != null) {
			reclamoActual.setRespuesta_administrador(reclamo.getRespuesta_administrador());
		}
		if (reclamo.getRespuesta_inspector()!=null) {
			reclamoActual.setRespuesta_inspector(reclamo.getRespuesta_inspector());
		}
		
		return cleanReclamo(this.reclamoRepository.save(reclamoActual));
	}
	
	//get ReclamosByUserId en caso de administrado
	@GetMapping("/byUserId")
	public List<Reclamo> getReclamoFilteredByUserId(
			@RequestParam("users_ids") String user_ids
			, @RequestParam("status_ids") String status_ids
			, @RequestParam("edificios_ids") String edificios_ids 
			, @RequestParam("especialidades_ids") String especialidades_ids
			){

		
		List<Reclamo> reclamos = this.reclamoRepository.findAll();
		List<Reclamo> responseReclamos = new ArrayList<>();
		

		for (int i = 0; i < reclamos.size(); i++) {
			Reclamo reclamo = reclamos.get(i);
			boolean goes = true;
			
			if ( (reclamo.getAdministrado() != null) && (user_ids !=  "") ) {
				if ( !user_ids.contains(String.valueOf(reclamo.getAdministrado().getId_user())) ) {
					goes = false;
				}
			}
			
			if ( (goes) && (reclamo.getEstado() != null)  && (status_ids != "")) {
				if ( !status_ids.contains(String.valueOf(reclamo.getEstado().getId_estado())) ) {
					goes = false;
				}
			}
			
			if ( (goes) && (reclamo.getEdificio()  != null) && (reclamo.getEdificio().getId_edificio() != 0)  && (edificios_ids != "")) {
				if ( !edificios_ids.contains(String.valueOf(reclamo.getEdificio().getId_edificio())) ) {
					goes = false;
				}
			}
			
			if ( (goes) && (reclamo.getEspecialidad() != null) && (reclamo.getEspecialidad().getId_especialidad() != 0)  && (especialidades_ids != "")) {
				if ( !especialidades_ids.contains(String.valueOf(reclamo.getEspecialidad().getId_especialidad())) ) {
					goes = false;
				}
			}
			
			if ( goes) {
				responseReclamos.add(cleanReclamo(reclamo));
			}
			
		}
		
		return responseReclamos;
	}
	
	//Clean Reclamo
	private Reclamo cleanReclamo (Reclamo reclamo) {
			if(reclamo.getAdministrado() != null) {
				Administrado administrado = reclamo.getAdministrado();
				administrado.setAdministradoUnidades(null);
				administrado.setReclamo(null);
				reclamo.setAdministrado(administrado);
			}
			
			if (reclamo.getUnidad() != null) {
				Unidad unidad = reclamo.getUnidad();
				unidad.setEdificio(null);
				reclamo.setUnidad(unidad);
			}
			
			if (reclamo.getEspacioComun() != null) {
				EspacioComun espacioComun = reclamo.getEspacioComun();
				espacioComun.setEdificio(null);
				reclamo.setEspacioComun(espacioComun);
			}
			
			
			if (reclamo.getEdificio() != null) {
				Edificio edificio = reclamo.getEdificio();
				edificio.setEspaciosComunes(null);
				edificio.setInspectores(null);
				
				edificio.setUnidades(null);
				reclamo.setEdificio(edificio);
			}
			
			
		return reclamo;
	}
}
