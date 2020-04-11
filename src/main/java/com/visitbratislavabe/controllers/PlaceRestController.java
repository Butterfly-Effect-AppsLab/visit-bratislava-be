package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.Place;
import com.visitbratislavabe.services.PlaceApiService;
import com.visitbratislavabe.services.PlaceRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

	@Autowired
	PlaceApiService placeApiService;

	@Autowired
	PlaceRepositoryService placeRepositoryService;

	@GetMapping("")
	public List<Place> getAllByCategory(@RequestParam String category) {
		return placeRepositoryService.getAllByCategory(category);
	}

	@PostMapping("")
	public List<Place> saveAll(@RequestBody List<Place> places) {
		return placeRepositoryService.saveAll(places);
	}

	@GetMapping("/{placeId}")
	public Place getById(@PathVariable long placeId) {
		return placeRepositoryService.getById(placeId);
	}

	// TODO: delete this endpoint once data are fetched from database
	@GetMapping("/rapid-api")
	public List<Place> getAllPlaces() {
		return placeApiService.getAllPlaces();
	}

}