package com.nasa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.nasa.exception.DataNotFoundException;
import com.nasa.model.Planet;
import com.nasa.model.PlanetSearchReq;
import com.nasa.repo.PlanetRepo;

@Service
public class PlanetService {

    private static final Logger log = LoggerFactory.getLogger(PlanetService.class);


    public List<Planet> getAllPlanets() {
        List<Planet> planetList = new ArrayList<>();
        planetList = PlanetRepo.getInstance().getPlanets();

        List<Planet> firstHundred = new ArrayList<>();

        firstHundred = planetList.stream().limit(10).collect(Collectors.toList());

        return firstHundred;
    }


    public List<Planet> searchBySingleField(PlanetSearchReq searchReq) throws DataNotFoundException {
        List<Planet> planetList = PlanetRepo.getInstance().getPlanets();

        List<Planet> bySingleField = new ArrayList<>();

        if (!StringUtils.isEmpty(searchReq.getHostName())) {
            log.info("searchBySingleField: hostName " + searchReq.getHostName());

            bySingleField = planetList.stream().filter(c -> c.getHostName().equals(searchReq.getHostName()))
                    .collect(Collectors.toList());

        } else if (!StringUtils.isEmpty(searchReq.getDiscoveryFacility())) {
            log.info("searchBySingleField: discoveryFacility " + searchReq.getDiscoveryFacility());

            bySingleField = planetList.stream().filter(c -> c.getDiscoveryFacility().equals(searchReq.getDiscoveryFacility()))
                    .collect(Collectors.toList());
        } else if (!StringUtils.isEmpty(searchReq.getDiscoveryMethod())) {
            log.info("searchBySingleField: discoveryMethod " + searchReq.getDiscoveryMethod());

            bySingleField = planetList.stream().filter(c -> c.getDiscoveryMethod().equals(searchReq.getDiscoveryMethod()))
                    .collect(Collectors.toList());
        } else if (!StringUtils.isEmpty(searchReq.getDiscoveryYear())) {
            log.info("searchBySingleField: discoveryYear " + searchReq.getDiscoveryYear());

            bySingleField = planetList.stream().filter(c -> c.getDiscoveryYear().equals(searchReq.getDiscoveryYear()))
                    .collect(Collectors.toList());
        }

        if (CollectionUtils.isEmpty(bySingleField)) {

            throw new DataNotFoundException("no planets with host name " + searchReq.getHostName());
        }

        log.info("serachByHostName: planet response " + bySingleField);

        return bySingleField;
    }






    //TODO- search by all fields
    public List<Planet> searchByAllFields(PlanetSearchReq multipleFields) throws DataNotFoundException {

        log.debug(String.valueOf(multipleFields));

        List<Planet> byMultipleFields = new ArrayList<>();

        List<Planet> planetList = PlanetRepo.getInstance().getPlanets();


        if (!ObjectUtils.isEmpty(multipleFields)) {
            byMultipleFields = planetList.stream().filter(planet ->
                            planet.getDiscoveryYear().equals(multipleFields.getDiscoveryYear()) &&
                                    planet.getDiscoveryMethod().equals(multipleFields.getDiscoveryMethod()) &&
                                    planet.getHostName().equals(multipleFields.getHostName()) &&
                                    planet.getDiscoveryFacility().equals(multipleFields.getDiscoveryFacility())
            ).collect(Collectors.toList());
        } else if(CollectionUtils.isEmpty(byMultipleFields)){

            throw new DataNotFoundException("No Results Match Criteria");
        }

        return byMultipleFields;
    }


//TODO- get hostname to be a link to the website
    //TODO- (discovery year)User can click on the up symbol to sort the rows in the results panel in ascending order on the values in that column.
    //TODO- (discovery method)User can click on the up symbol to sort the rows in the results panel in ascending order on the values in that column.
    //TODO- (discovery facility)User can click on the up symbol to sort the rows in the results panel in ascending order on the values in that column.


    //TODO- (host name)User can click on the down symbol to sort the rows in the results panel in descending order on the values in the column.
    //TODO- (discovery year)User can click on the down symbol to sort the rows in the results panel in descending order on the values in the column.
    //TODO- (discovery method)User can click on the down symbol to sort the rows in the results panel in descending order on the values in the column.
    //TODO- (discovery facility)User can click on the down symbol to sort the rows in the results panel in descending order on the values in the column.



    //TODO- (host name)User can click on the up symbol to sort the rows in the results panel in ascending order on the values in that column.
    public List<Planet> sortByHostName(List<Planet> planets) throws DataNotFoundException{

        if(!CollectionUtils.isEmpty(planets)){

            return planets.stream().sorted((planetOne, planetTwo) -> planetOne.getHostName().compareToIgnoreCase(planetTwo.getHostName())).collect(Collectors.toList());

        } else {
            throw new DataNotFoundException("No List Available to Sort");
        }

    }




}
