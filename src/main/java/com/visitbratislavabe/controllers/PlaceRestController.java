package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.services.PlaceRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceRestController {

	@Autowired
	PlaceRepositoryService placeRepositoryService;

	@GetMapping("")
	public List<Place> getByCategory(@RequestParam String category) {
		return placeRepositoryService.getByCategory(category);
	}

	@PostMapping("")
	public List<Place> saveAll(@RequestBody List<Place> places) {
		return placeRepositoryService.saveAll(places);
	}

	@GetMapping("/{placeId}")
	public Place getById(@PathVariable long placeId) {
		return placeRepositoryService.getById(placeId);
	}

}