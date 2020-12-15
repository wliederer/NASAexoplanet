package com.nasa.util;

import org.springframework.util.StringUtils;

import com.nasa.model.PlanetSearchReq;

public class SearchRequestValidate {

	public static String getSingleField(PlanetSearchReq searchReq) {
		String field = "";
		
		if(!StringUtils.isEmpty(searchReq.getHostName())) {
			field = searchReq.getHostName();
		} else if(!StringUtils.isEmpty(searchReq.getDiscoveryFacility())) {
			field = searchReq.getDiscoveryFacility();
		} else if(!StringUtils.isEmpty(searchReq.getDiscoveryMethod())) {
			field = searchReq.getDiscoveryMethod();
		} else if(!StringUtils.isEmpty(searchReq.getDiscoveryYear())) {
			field = searchReq.getDiscoveryYear();
		}
		return field;
	}


}
