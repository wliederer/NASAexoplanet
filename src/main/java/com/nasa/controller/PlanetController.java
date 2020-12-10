package com.nasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.model.Planet;
import com.nasa.service.PlanetService;

@RestController
@RequestMapping("NASA")
@CrossOrigin(origins="*")
public class PlanetController {
	
	@Autowired
	private PlanetService planetService;
	
	@GetMapping("/health")
	public ResponseEntity<String> healthCheck(){
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
	
	@GetMapping("/allPlanets")
	public ResponseEntity<List<Planet>> getAllPlanets(){
		List<Planet> resp;
		resp = planetService.getAllPlanets();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
