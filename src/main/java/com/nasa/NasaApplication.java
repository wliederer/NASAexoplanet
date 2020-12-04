package com.nasa;

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
		loadCSV();
	}

	public static void loadCSV() {

		List<List<String>> records  = new ArrayList<>();
		try{

			BufferedReader br = new BufferedReader(new FileReader("planetsedit.csv"));
			String line;
			while((line = br.readLine()) != null) {
				String[] values = line.split("(\\d+)(,\\s*\\d+)*");
				records.add(Arrays.asList(values));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println(records);
	}

}
