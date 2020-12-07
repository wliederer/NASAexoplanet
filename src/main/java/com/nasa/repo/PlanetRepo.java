package com.nasa.repo;

import java.util.List;


import com.nasa.model.Planet;


public class PlanetRepo {
	
	private static PlanetRepo singleton = null;
	
	public List<Planet> planets;
	
	private PlanetRepo() {
		
	}
	
	public static PlanetRepo getInstance() {
		if(singleton == null) {
			singleton = new PlanetRepo();
		}
		
		return singleton;
	}
	
	public List<Planet> getPlanets(){
		return this.planets;
	}
	
	public void setPlanets(List<Planet> planet) {
		this.planets = planet;
	}


}
