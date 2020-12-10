package com.nasa.maper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.model.Planet;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brittanytinnin on 12/4/20 1:15 PM
 */
public class PlanetMapper {


    //convert CSVfile to List of Planet Objects
    //write list of planet objects as Json file

    public List<Planet> convertCsvFileToPlanetObjectList() {
        BufferedReader fileReader;
        CSVParser csvParser;
        Long count = 0l;

        List<Planet> planets = new ArrayList<>();

        try {
            fileReader = new BufferedReader(new FileReader("planets.csv"));
            csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();


            //          String[] csvNames = {"pl_name", "hostname", "default_flag", "sy_snum", "sy_pnum", "discoverymethod", "disc_year", "disc_facility", "soltype", "pl_controv_flag", "pl_refname", "pl_orbper", "pl_orbpererr1", "pl_orbpererr2", "pl_orbperlim", "pl_orbsmax", "pl_orbsmaxerr1", "pl_orbsmaxerr2", "pl_orbsmaxlim", "pl_rade", "pl_radeerr1", "pl_radeerr2", "pl_radelim", "pl_radj", "pl_radjerr1", "pl_radjerr2", "pl_radjlim", "pl_bmasse", "pl_bmasseerr1", "pl_bmasseerr2", "pl_bmasselim", "pl_bmassj", "pl_bmassjerr1", "pl_bmassjerr2", "pl_bmassjlim", "pl_bmassprov", "pl_orbeccen", "pl_orbeccenerr1", "pl_orbeccenerr2", "pl_orbeccenlim", "pl_insol", "pl_insolerr1", "pl_insolerr2", "pl_insollim", "pl_eqt", "pl_eqterr1", "pl_eqterr2", "pl_eqtlim", "ttv_flag", "st_refname", "st_teff", "st_tefferr1", "st_tefferr2", "st_tefflim", "st_rad", "st_raderr1", "st_raderr2", "st_radlim", "st_mass", "st_masserr1", "st_masserr2", "st_masslim", "st_met", "st_meterr1", "st_meterr2", "st_metlim", "st_metratio", "st_logg", "st_loggerr1", "st_loggerr2", "st_logglim", "sy_refname", "rastr", "ra", "decstr", "dec", "sy_dist", "sy_disterr1", "sy_disterr2", "sy_vmag", "sy_vmagerr1", "sy_vmagerr2", "sy_kmag", "sy_kmagerr1", "sy_kmagerr2", "sy_gaiamag", "sy_gaiamagerr1", "sy_gaiamagerr2", "rowupdate", "pl_pubdate", "releasedate"};


//
//
//
//            for(CSVRecord csvRecord : csvRecords){
//                for(int i=0; i<csvNames.length; i++){
//
//                        csvRecord.get(csvNames[i]);
//
//                }
//            }

            for (CSVRecord csvRecord : csvRecords) {
            	
                Planet planet = new Planet(
                		
                        count, csvRecord.get("pl_name"),
                        csvRecord.get("hostname"),
                        csvRecord.get("default_flag"),
                        csvRecord.get("sy_snum"),
                        csvRecord.get("sy_pnum"),
                        csvRecord.get("discoverymethod"),
                        csvRecord.get("disc_year"),
                        csvRecord.get("disc_facility"),
                        csvRecord.get("soltype"),
                        csvRecord.get("pl_controv_flag"),
                        csvRecord.get("pl_refname"),
                        csvRecord.get("pl_orbper"),
                        csvRecord.get("pl_orbpererr1"),
                        csvRecord.get("pl_orbpererr2"),
                        csvRecord.get("pl_orbperlim"),
                        csvRecord.get("pl_orbsmax"),
                        csvRecord.get("pl_orbsmaxerr1"),
                        csvRecord.get("pl_orbsmaxerr2"),
                        csvRecord.get("pl_orbsmaxlim"),
                        csvRecord.get("pl_rade"),
                        csvRecord.get("pl_radeerr1"),
                        csvRecord.get("pl_radeerr2"),
                        csvRecord.get("pl_radelim"),
                        csvRecord.get("pl_radj"),
                        csvRecord.get("pl_radjerr1"),
                        csvRecord.get("pl_radjerr2"),
                        csvRecord.get("pl_radjlim"),
                        csvRecord.get("pl_bmasse"),
                        csvRecord.get("pl_bmasseerr1"),
                        csvRecord.get("pl_bmasseerr2"),
                        csvRecord.get("pl_bmasselim"),
                        csvRecord.get("pl_bmassj"),
                        csvRecord.get("pl_bmassjerr1"),
                        csvRecord.get("pl_bmassjerr2"),
                        csvRecord.get("pl_bmassjlim"),
                        csvRecord.get("pl_bmassprov"),
                        csvRecord.get("pl_orbeccen"),
                        csvRecord.get("pl_orbeccenerr1"),
                        csvRecord.get("pl_orbeccenerr2"),
                        csvRecord.get("pl_orbeccenlim"),
                        csvRecord.get("pl_insol"),
                        csvRecord.get("pl_insolerr1"),
                        csvRecord.get("pl_insolerr2"),
                        csvRecord.get("pl_insollim"),
                        csvRecord.get("pl_eqt"),
                        csvRecord.get("pl_eqterr1"),
                        csvRecord.get("pl_eqterr2"),
                        csvRecord.get("pl_eqtlim"),
                        csvRecord.get("ttv_flag"),
                        csvRecord.get("st_refname"),
                        csvRecord.get("st_teff"),
                        csvRecord.get("st_tefferr1"),
                        csvRecord.get("st_tefferr2"),
                        csvRecord.get("st_tefflim"),
                        csvRecord.get("st_rad"),
                        csvRecord.get("st_raderr1"),
                        csvRecord.get("st_raderr2"),
                        csvRecord.get("st_radlim"),
                        csvRecord.get("st_mass"),
                        csvRecord.get("st_masserr1"),
                        csvRecord.get("st_masserr2"),
                        csvRecord.get("st_masslim"),
                        csvRecord.get("st_met"),
                        csvRecord.get("st_meterr1"),
                        csvRecord.get("st_meterr2"),
                        csvRecord.get("st_metlim"),
                        csvRecord.get("st_metratio"),
                        csvRecord.get("st_logg"),
                        csvRecord.get("st_loggerr1"),
                        csvRecord.get("st_loggerr2"),
                        csvRecord.get("st_logglim"),
                        csvRecord.get("sy_refname"),
                        csvRecord.get("rastr"),
                        csvRecord.get("ra"),
                        csvRecord.get("decstr"),
                        csvRecord.get("dec"),
                        csvRecord.get("sy_dist"),
                        csvRecord.get("sy_disterr1"),
                        csvRecord.get("sy_disterr2"),
                        csvRecord.get("sy_vmag"),
                        csvRecord.get("sy_vmagerr1"),
                        csvRecord.get("sy_vmagerr2"),
                        csvRecord.get("sy_kmag"),
                        csvRecord.get("sy_kmagerr1"),
                        csvRecord.get("sy_kmagerr2"),
                        csvRecord.get("sy_gaiamag"),
                        csvRecord.get("sy_gaiamagerr1"),
                        csvRecord.get("sy_gaiamagerr2"),
                        csvRecord.get("rowupdate"),
                        csvRecord.get("pl_pubdate"),
                        csvRecord.get("releasedate")
                );

                planets.add(planet);
                count++;

            }


        } catch (Exception e) {
            System.out.println("Error reading CSV file!");
            e.printStackTrace();
        }

//        System.out.println(planets);
        return planets;
    }





    public void writePlanetObjectsToJsonFile(List<Planet> planets, String jsonFile){

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File(jsonFile);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, planets);
        }catch(Exception e){
            System.out.println("Error creating JSON File!");
            e.printStackTrace();
        }


    }

}
