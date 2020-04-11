package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.Itinerary;
import com.visitbratislavabe.dbmodels.Place;
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

	@PutMapping("/")
	public Itinerary updateItinerary(@RequestBody Itinerary itinerary) {
		return itineraryRepositoryService.update(itinerary);
	}

	@DeleteMapping("/{itineraryId}")
	public void deleteItinerary(@PathVariable long itineraryId) {
		itineraryRepositoryService.deleteById(itineraryId);
	}

	@PostMapping("/{itineraryId}/places")
	public void addPlace(@PathVariable long itineraryId, @RequestBody List<Place> places) {
		Itinerary itinerary = itineraryRepositoryService.getById(itineraryId);
		itinerary.addPlaces(places);
		itineraryRepositoryService.save(itinerary);
	}

	@DeleteMapping("/{itineraryId}/places")
	public void removePlace(@PathVariable long itineraryId, @RequestBody List<Place> places) {
		Itinerary itinerary = itineraryRepositoryService.getById(itineraryId);
		itinerary.removePlaces(places);
		itineraryRepositoryService.save(itinerary);
	}

	@GetMapping("/{itineraryId}/places")
	public void getAllItineraryPlaces(@PathVariable long itineraryId) {
		itineraryRepositoryService.getAllItineraryPlaces(itineraryId);
	}

}
