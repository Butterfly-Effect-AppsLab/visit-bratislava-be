package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.services.PlaceApiService;
import com.visitbratislavabe.services.utils.PlacesResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

	@Autowired
	PlaceApiService placeApiService;

	@GetMapping("/")
	public List<PlaceDto> getAllPlaces() {
		return placeApiService.getAllPlaces();
	}

}