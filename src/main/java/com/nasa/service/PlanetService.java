package com.nasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nasa.model.Planet;
import com.nasa.repo.PlanetRepo;

@Service
public class PlanetService {
	
	
	public List<Planet> getAllPlanets(){
		List<Planet> planetList = new ArrayList<>();
		
		planetList = PlanetRepo.getInstance().getPlanets();
		
		List<Planet> firstHundred = new ArrayList<>();
		
		firstHundred = planetList.stream().limit(10).collect(Collectors.toList());
		
		return firstHundred;
	}
	
	

}
