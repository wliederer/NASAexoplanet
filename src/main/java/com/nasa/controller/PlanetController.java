package com.nasa.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.nasa.exception.DataNotFoundException;
import com.nasa.exception.NoValidSearchException;
import com.nasa.model.Planet;
import com.nasa.model.PlanetSearchReq;
import com.nasa.service.PlanetService;
import com.nasa.util.SearchRequestValidate;

@RestController
@RequestMapping("NASA")
@CrossOrigin(origins = "*")
public class PlanetController {

    private static final Logger log = LoggerFactory.getLogger(PlanetController.class);

    @Autowired
    private PlanetService planetService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping("/allPlanets")
    public ResponseEntity<List<Planet>> getAllPlanets() {
    	log.info("method all planets");
        List<Planet> resp;
        resp = planetService.getAllPlanets();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/searchPlanets")
    public ResponseEntity<List<Planet>> searchPlanets(@RequestBody PlanetSearchReq searchReq) throws DataNotFoundException, NoValidSearchException {
        List<Planet> resp = new ArrayList<>();
        log.info("searchReq " + searchReq);

        String field = SearchRequestValidate.getSingleField(searchReq);

        if (!StringUtils.isEmpty(field)) {

            log.info("searchPlanets: searching " + field);

            resp = planetService.searchBySingleField(searchReq);

        } else if (field.contentEquals("")) {

            throw new NoValidSearchException("no fields passed for search");
        }

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @PostMapping("/searchPlanetsWithFields")
    public ResponseEntity<List<Planet>> searchPlanetsMultipleFields(@RequestBody PlanetSearchReq searchDetails) throws DataNotFoundException, NoValidSearchException {
		log.info("search details: " + searchDetails);
        List<Planet> response;


        if (!ObjectUtils.isEmpty(searchDetails)) {

            response = planetService.searchByAllFields(searchDetails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new NoValidSearchException("Search Fields Empty");
        }
    }


    @PostMapping("/sort-planets-asc/{category}")
    public ResponseEntity<List<Planet>> ascendingSortBy(@RequestBody List<Planet> planets, @PathVariable("category") String category) throws DataNotFoundException, NoValidSearchException {
        List<Planet> response;

        if(!CollectionUtils.isEmpty(planets) && category.contentEquals("hostName")){
            response = planetService.sortByHostNameAsc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryFacility")){
            response = planetService.sortByFacilityAsc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryMethod")){
            response = planetService.sortByMethodAsc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryYear")){
            response = planetService.sortByYearAsc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new NoValidSearchException("No Data Found for Search.");
        }
    }



    @PostMapping("/sort-planets-desc/{category}")
    public ResponseEntity<List<Planet>> descendingSortBy(@RequestBody List<Planet> planets, @PathVariable("category") String category) throws DataNotFoundException, NoValidSearchException {
        List<Planet> response;

        if(!CollectionUtils.isEmpty(planets) && category.contentEquals("hostName")){
            response = planetService.sortByHostNameDesc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryFacility")){
            response = planetService.sortByFacilityDesc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryMethod")){
            response = planetService.sortByMethodDesc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if(!CollectionUtils.isEmpty(planets) && category.contentEquals("discoveryYear")){
            response = planetService.sortByYearDesc(planets);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new NoValidSearchException("No Data Found for Search.");
        }
    }
}
