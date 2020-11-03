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
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.FotoRepository;

@RestController 
@RequestMapping("api/fotos")
public class FotoController {
	@Autowired
	private FotoRepository fotoRepository;
	
	//create Foto
	@PostMapping
	public Foto createFoto(@RequestBody Foto foto) {
		return this.fotoRepository.save(foto);
	}
	
	//get all Fotos
	@GetMapping
	public List<Foto> getAllFoto(){
		List<Foto> fotos = this.fotoRepository.findAll();
//		for (int i = 0; i < fotos.size(); i++) {
//			fotos.set(i, cleanFotos(fotos.get(i)));
//		}
		return fotos;
	}
	//get foto by id
	@GetMapping("/{id}")
	public Foto getFotoById(@PathVariable (value="id") long fotoId) {
		Foto foto = this.fotoRepository.findById(fotoId)
				.orElseThrow(() -> new ResourceNotFoundException("Foto not fount whth ID" + fotoId));
		return foto;
	}
	//delete Foto by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Foto>  deleteFotoById(@PathVariable (value="id") long fotoId) {
		Foto fotoExisting = this.fotoRepository.findById(fotoId)
				.orElseThrow(()-> new ResourceNotFoundException("No existe Foto para eliminar" +fotoId));
		this.fotoRepository.delete(fotoExisting);
		return ResponseEntity.ok().build();
	}
	
	//update Foto by ID
	@PutMapping("/{id}")
	public Foto updateFotoById(@RequestBody Foto foto, @PathVariable (value="id") long fotoId) {
		Foto fotoActual = this.fotoRepository.findById(fotoId)
				.orElseThrow(() -> new ResourceNotFoundException("Foto not fount whth ID" + fotoId));
		fotoActual.setUri_foto(foto.getUri_foto()); 
		return this.fotoRepository.save(fotoActual);
	}
//	private Foto cleanEstado (Foto foto) {
////Edificio edificio = espaciocomun.getEdificio();
////edificio.setUnidades(null);
////edificio.setEspaciosComunes(null);
////espaciocomun.setEdificio(edificio);
//
//return foto;
//}
}
