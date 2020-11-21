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

import com.AplicacionesInteractivas.TP.entity.Foto;
import com.AplicacionesInteractivas.TP.entity.Notificacion;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.NotificacionRepository;

@RestController 
@RequestMapping("api/notificaciones")
public class NotificacionController {
	@Autowired
	private NotificacionRepository notificacionRepository;
	
	//create Notificacion
	@PostMapping
	public Notificacion createNotificacion(@RequestBody Notificacion notificacion) {
		return this.notificacionRepository.save(notificacion);
	}
	
	//get all Notificaciones
	@GetMapping
	public List<Notificacion> getAllNotificaciones(){
		List<Notificacion> notificaciones = this.notificacionRepository.findAll();
		return notificaciones;
	}
	
	//get Notificacion by id
	@GetMapping("/{id}")
	public Notificacion getNotificacionById(@PathVariable (value="id") long notificacionId) {
		Notificacion notificacion = this.notificacionRepository.findById(notificacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Foto not fount whth ID" + notificacionId));
		return notificacion;
	}
	
	//delete Notificacion by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Notificacion>  deleteNotificacionById(@PathVariable (value="id") long notificacionId) {
		Notificacion notifExisting = this.notificacionRepository.findById(notificacionId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Notificacion para eliminar" +notificacionId));
		this.notificacionRepository.delete(notifExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Foto by ID
	@PutMapping("/{id}")
	public Notificacion updateNotificacionById(@RequestBody Notificacion notificacion, @PathVariable (value="id") long notificacionId) {
		Notificacion notificaActual = this.notificacionRepository.findById(notificacionId)
				.orElseThrow(() -> new ResourceNotFoundException("Notificacon no encontrada con el ID" + notificacionId));
		if (notificacion.getDescripcion()!= null) {
			notificaActual.setDescripcion(notificacion.getDescripcion());
		}
		
		if (notificacion.getId_administrdo() != 0) {
			notificaActual.setId_administrdo(notificacion.getId_administrdo());
		}	
		
		if (notificacion.getId_reclamo() != 0) {
			notificaActual.setId_reclamo(notificacion.getId_reclamo());
		}	

		return this.notificacionRepository.save(notificaActual);
	}
	
	//get all Notificaciones By id_administrado
	//@GetMapping
	public List<Notificacion> getAllNotificacionesByAdministradoID(@PathVariable (value="id") long adminstradoId){
		List<Notificacion> Allnotificaciones = this.notificacionRepository.findAll(); //todas las noticaciones
		List<Notificacion> notificaResult = null; //notificaciones que tienen el ID de administrado buscado
		Notificacion notificacion=null;
		int j=0;
		if (Allnotificaciones.size() != 0){
			for (int i = 0; i < Allnotificaciones.size(); i++) {
				notificacion=Allnotificaciones.get(i);
				if(notificacion.getId_administrdo()==adminstradoId) {
					notificaResult.set(j, notificacion);
					j++;
				}
			}
				
		}
				
		return notificaResult;
	}
	
}
