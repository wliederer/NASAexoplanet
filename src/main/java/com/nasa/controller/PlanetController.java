package com.nasa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.exception.DataNotFoundException;
import com.nasa.model.Planet;
import com.nasa.model.PlanetSearchReq;
import com.nasa.service.PlanetService;

@RestController
@RequestMapping("NASA")
@CrossOrigin(origins="*")
public class PlanetController {
	
	private static final Logger log = LoggerFactory.getLogger(PlanetController.class);
	
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
	
	@PostMapping("/searchPlanets")
	public ResponseEntity<List<Planet>> searchPlanets(@RequestBody PlanetSearchReq searchReq) throws DataNotFoundException{
		List<Planet> resp = new ArrayList<>();
		log.info("searchReq "+searchReq);
		
		if(!StringUtils.isEmpty(searchReq.getHostName())) {
			
			log.info("searchPlanets: searching "+searchReq);
			resp = planetService.searchByHostName(searchReq);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
