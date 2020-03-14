package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.services.PlaceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController implements IPlaceRestController {

	@Autowired
    PlaceApiService placeRestService;

	@Override
    @GetMapping("/random")
	public Place getRandomPlace() {
		return placeRestService.getRandomPlace();
	}

}
