package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.Itinerary;
import com.visitbratislavabe.services.ItineraryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryRestController {

	@Autowired
	ItineraryRepositoryService itineraryRepositoryService;

	@GetMapping("")
	public List<Itinerary> getAllByCategory(@RequestParam String category) {
		return itineraryRepositoryService.getAllByCategory(category);
	}

	@PostMapping("")
	public Itinerary createNew(@RequestBody Itinerary itinerary) {
		return itineraryRepositoryService.save(itinerary);
	}

	@GetMapping("/{itineraryId}")
	public Itinerary getItinerary(@PathVariable long itineraryId) {
		return itineraryRepositoryService.getById(itineraryId);
	}

	@PutMapping("/{itineraryId}")
	public Itinerary updateItinerary(@RequestBody Itinerary itinerary) {
		return itineraryRepositoryService.update(itinerary);
	}

	@DeleteMapping("/{itineraryId}")
	public void deleteItinerary(@PathVariable long itineraryId) {
		itineraryRepositoryService.delete(itineraryId);
	}

	@PostMapping("/{itineraryId}/places/{placeId}")
	public void addPlace(@PathVariable long itineraryId, @PathVariable long placeId) {
		itineraryRepositoryService.addPlace(itineraryId, placeId);
	}

	@PostMapping("/{itineraryId}/places/{placeId}")
	public void removePlace(@PathVariable long itineraryId, @PathVariable long placeId) {
		itineraryRepositoryService.removePlace(itineraryId, placeId);
	}

	@GetMapping("/{itineraryId}/places")
	public void getAllItineraryPlaces(@PathVariable long itineraryId) {
		itineraryRepositoryService.getAllItineraryPlaces(itineraryId);
	}

}
