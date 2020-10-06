package com.AplicacionesInteractivas.TP.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Reclamo;
import com.AplicacionesInteractivas.TP.repository.ReclamoRepository;

@RestController 
@RequestMapping("api/reclamos")

public class ReclamoController {
	
	@Autowired
	private ReclamoRepository reclamoRepository;
	
	//ceate Reclamo
	@PostMapping
	public Reclamo createReclamo(@RequestBody Reclamo reclamo) {
		return this.reclamoRepository.save(reclamo);
	}
	
	
	//get all Reclamos
	@GetMapping
	public List<Reclamo> getAllReclamos(){
		return this.reclamoRepository.findAll();
	}
	//get Reclamo by Id
	//update Reclamo

}
