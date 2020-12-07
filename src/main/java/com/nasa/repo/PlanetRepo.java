package com.nasa.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nasa.maper.PlanetMapper;
import com.nasa.model.Planet;

@Repository
public class PlanetRepo {
	
	public List<Planet> getPlanets(){
		PlanetMapper planetMapper = new PlanetMapper();
		List<Planet> planets = planetMapper.convertCsvFileToPlanetObjectList();
		
		return planets;
	}

}
