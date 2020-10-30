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

import com.AplicacionesInteractivas.TP.entity.Configuracion;
import com.AplicacionesInteractivas.TP.entity.Inspector;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.ConfiguracionRepository;


@RestController 
@RequestMapping("api/configuraciones")
public class ConfiguracionController {
	@Autowired
	private ConfiguracionRepository configuracionRepository;
	
	//CreateConfiguracion
	@PostMapping
	public Configuracion createConfiguracion(@RequestBody Configuracion configuracion) {
		return this.configuracionRepository.save(configuracion);
	}
	
	//get all Configuraciones
	@GetMapping
	public List<Configuracion> getAllConfiguraciones(){
		return this.configuracionRepository.findAll();
	}
	
	//get Configuracion by id
		@GetMapping("/{id}")
		public Configuracion getConfiguracionById(@PathVariable (value="id") long configuracionID) {
			
			return this.configuracionRepository.findById(configuracionID)
					.orElseThrow(() -> new ResourceNotFoundException("Configuracion not fount whth ID" + configuracionID));
		}
		
		//delete configuracion by id
		@DeleteMapping("/{id}")
		public ResponseEntity<Configuracion>  deleteConfiguracionById(@PathVariable (value="id") long configuracionID) {
			Configuracion confExisting = this.configuracionRepository.findById(configuracionID)
					.orElseThrow(()-> new ResourceNotFoundException("No existe Configuracion para eliminar" +configuracionID));
			this.configuracionRepository.delete(confExisting);
			return ResponseEntity.ok().build();
		}
}
