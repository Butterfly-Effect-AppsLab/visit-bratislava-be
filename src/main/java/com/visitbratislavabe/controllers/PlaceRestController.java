package com.visitbratislavabe.controllers;

import com.visitbratislavabe.services.PlaceApiService;
import com.visitbratislavabe.services.utils.PlacesResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController implements IPlaceRestController {

	@Autowired
	PlaceApiService placeApiService;

	@Override
	@GetMapping("/")
	public PlacesResponseWrapper getAllPlaces() {
		return placeApiService.getAllPlaces();
	}

}
