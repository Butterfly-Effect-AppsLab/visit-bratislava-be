package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.services.ItineraryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryRestController {

	@Autowired
	ItineraryRepositoryService itineraryRepositoryService;

	@PostMapping("")
	public Itinerary createNew(@RequestBody Itinerary itinerary) {
		return itineraryRepositoryService.save(itinerary);
	}

	@GetMapping("")
	public List<Itinerary> getAllByCategory(@RequestParam String category) {
		return itineraryRepositoryService.getAllByCategory(category);
	}

	@GetMapping("/{itineraryId}")
	public Itinerary getItinerary(@PathVariable long itineraryId) {
		return itineraryRepositoryService.getById(itineraryId);
	}

	@PutMapping("")
	public Itinerary updateItinerary(@RequestBody Itinerary itinerary) {
		return itineraryRepositoryService.update(itinerary);
	}

	@DeleteMapping("/{itineraryId}")
	public void deleteItinerary(@PathVariable long itineraryId) {
		itineraryRepositoryService.deleteById(itineraryId);
	}

	@PostMapping("/{itineraryId}/places")
	public Set<Place> addPlaces(@PathVariable long itineraryId, @RequestBody List<Place> places) {
		return itineraryRepositoryService.addPlaces(itineraryId, places);
	}

	@DeleteMapping("/{itineraryId}/places")
	public void removePlaces(@PathVariable long itineraryId, @RequestBody List<Place> places) {
		itineraryRepositoryService.removePlaces(itineraryId, places);
	}

	@GetMapping("/{itineraryId}/places")
	public Set<Place> getAllItineraryPlaces(@PathVariable long itineraryId) {
		return itineraryRepositoryService.getAllItineraryPlaces(itineraryId);
	}

}
