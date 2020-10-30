package com.AplicacionesInteractivas.TP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.repository.InspectorEspecialidadRepository;

@RestController 
@RequestMapping("api/inspectorespecialidad")
public class InspectorEspecialidadController {
	@Autowired
	private InspectorEspecialidadRepository inspectorespecialidadrepository;
}
