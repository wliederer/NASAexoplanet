package com.nasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nasa.exception.DataNotFoundException;
import com.nasa.model.Planet;
import com.nasa.model.PlanetSearchReq;
import com.nasa.repo.PlanetRepo;

@Service
public class PlanetService {
	
	private static final Logger log = LoggerFactory.getLogger(PlanetService.class);
	
	
	public List<Planet> getAllPlanets(){
		List<Planet> planetList = new ArrayList<>();
		planetList = PlanetRepo.getInstance().getPlanets();
		
		List<Planet> firstHundred = new ArrayList<>();

		//TODO Is this for the first 100 or 10?
		firstHundred = planetList.stream().limit(10).collect(Collectors.toList());
		
		return firstHundred;
	}
	
	public List<Planet> searchByHostName(PlanetSearchReq searchReq) throws DataNotFoundException{
		List<Planet> planetList = new ArrayList<>();
		planetList = PlanetRepo.getInstance().getPlanets();
		
		List<Planet> byHostName;	
		byHostName = planetList.stream().filter(c->c.getHostName().equals(searchReq.getHostName()))
				.collect(Collectors.toList());
		
		if(CollectionUtils.isEmpty(byHostName)) {
			
			throw new DataNotFoundException("no planets with host name "+searchReq.getHostName());
		}
		
		log.info("serachByHostName: planet response "+byHostName);
		
		return byHostName;
	}
	
	

}
