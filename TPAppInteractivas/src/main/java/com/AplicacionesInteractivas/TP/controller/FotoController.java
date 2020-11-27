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
import com.AplicacionesInteractivas.TP.entity.FotoFront;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.FotoRepository;

@RestController 
@RequestMapping("api/fotos")
public class FotoController {
	@Autowired
	private FotoRepository fotoRepository;
	
	//create Foto
	@PostMapping
	public Foto createFoto(@RequestBody FotoFront fotoFront) {
		Foto foto = new Foto();
		foto.setId_foto(fotoFront.getId_foto());
		
		byte[] bytes = fotoFront.getFoto().getBytes();
		foto.setFoto(bytes);
		
		return this.fotoRepository.save(foto);
	}
	
	//get all Fotos
	@GetMapping
	public List<Foto> getAllFoto(){
		List<Foto> fotos = this.fotoRepository.findAll();
		return fotos;
	}
	//get foto by id
	@GetMapping("/{id}")
	public FotoFront getFotoById(@PathVariable (value="id") long fotoId) {
		Foto foto = this.fotoRepository.findById(fotoId)
				.orElseThrow(() -> new ResourceNotFoundException("Foto not fount whth ID" + fotoId));
		
		FotoFront fotoFront = new FotoFront();
		fotoFront.setId_foto(foto.getId_foto());
		
		
		fotoFront.setFoto(new String(foto.getFoto()));
		
		return fotoFront;
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
	public Foto updateFotoById(@RequestBody FotoFront fotoFront, @PathVariable (value="id") long fotoId) {
		Foto foto = new Foto();
		
		if (fotoFront.getFoto() != null) {
			Foto fotoActual = this.fotoRepository.findById(fotoId)
					.orElseThrow(() -> new ResourceNotFoundException("Foto not fount whth ID" + fotoId));
			
			foto.setId_foto(fotoActual.getId_foto());
			
			byte[] bytes= fotoFront.getFoto().getBytes();  
			foto.setFoto(bytes);
		}
						
		return this.fotoRepository.save(foto);
	}
}
