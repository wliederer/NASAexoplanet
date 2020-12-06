package com.nasa;

import com.nasa.maper.PlanetMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class NasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);

		PlanetMapper planetMapper = new PlanetMapper();
		planetMapper.convertCsvFileToPlanetObjectList();
	}



}
