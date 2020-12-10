package com.nasa.model;

import lombok.Data;

@Data
public class PlanetSearchReq {
	
	private String discoveryYear;
	private String discoveryMethod;
	private String hostName;
	private String discoveryFacility;

}
