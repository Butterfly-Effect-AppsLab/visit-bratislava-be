package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.PlaceDto;
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

	@GetMapping("/")
	public List<PlaceDto> getAllPlaces() {
		return placeApiService.getAllPlaces();
	}

	@PostMapping("/saveAll")
	public Iterable<PlaceDto> saveAllPlaces(@RequestBody Iterable<PlaceDto> places) {
		return placeRepositoryService.saveAll(places);
	}

}