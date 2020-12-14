package com.nasa;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nasa.maper.PlanetMapper;
import com.nasa.model.Planet;
import com.nasa.repo.PlanetRepo;


@SpringBootApplication
public class NasaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);

		PlanetMapper planetMapper = new PlanetMapper();
		List<Planet> planets = planetMapper.convertCsvFileToPlanetObjectList();
		PlanetRepo.getInstance().setPlanets(planets);
		System.out.println("set planets to PlanetRepo");
//		planetMapper.writePlanetObjectsToJsonFile(planets, "planets.json");
	}



}
