package com.AplicacionesInteractivas.TP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.AplicacionesInteractivas.TP.repository.InspectorEdificioRepository;


@RestController 
@RequestMapping("api/inspectoredificios")
public class InspectorEdificioController {

	@Autowired
	private InspectorEdificioRepository inspectorEdificiorRepository;
	
}
