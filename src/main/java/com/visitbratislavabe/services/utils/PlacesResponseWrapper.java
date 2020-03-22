package com.visitbratislavabe.services.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.visitbratislavabe.dbmodels.PlaceDto;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlacesResponseWrapper {

	public List<PlaceDto> data;

	public PlacesResponseWrapper() {
	}

}
