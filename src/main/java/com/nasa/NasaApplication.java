package com.nasa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class NasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);

//		PlanetMapper planetMapper = new PlanetMapper();
//		List<Planet> planets = planetMapper.convertCsvFileToPlanetObjectList();
//		planetMapper.writePlanetObjectsToJsonFile(planets, "planets.json");
	}



}
