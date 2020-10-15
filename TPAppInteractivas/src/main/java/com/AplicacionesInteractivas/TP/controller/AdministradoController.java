package com.AplicacionesInteractivas.TP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.Administrado;
import com.AplicacionesInteractivas.TP.entity.User;
import com.AplicacionesInteractivas.TP.repository.AdministradoRepository;


@RestController 
@RequestMapping("api/administrado")
public class AdministradoController {
	
	@Autowired
	private AdministradoRepository administradoRepository;
	
	@GetMapping
	public List<Administrado> getAllUsers(){
		return this.administradoRepository.findAll();
	}
	
	//create user
	@PostMapping
	public Administrado createUser(@RequestBody Administrado administrado) {
		return this.administradoRepository.save(administrado);
	}
	
}
