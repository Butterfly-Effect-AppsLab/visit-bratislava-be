package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.services.ItineraryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryRestController {

	@Autowired
	ItineraryRepositoryService itineraryRepositoryService;

	@GetMapping("/")
	public Iterable<ItineraryDto> getItineraries(@RequestParam String category) {
		return itineraryRepositoryService.getItineraries(category);
	}

	@PostMapping("/")
	public ItineraryDto saveItinerary(@RequestBody ItineraryDto itinerary) {
		return itineraryRepositoryService.saveItinerary(itinerary);
	}

	@GetMapping("/{itineraryId}")
	public ItineraryDto getItinerary(@PathVariable Long itineraryId) {
		return itineraryRepositoryService.getItinerary(itineraryId);
	}

	@PutMapping("/{itineraryId}")
	public void updateItinerary(@PathVariable Long itineraryId, @RequestBody ItineraryDto itinerary) {
		itineraryRepositoryService.updateItinerary(itineraryId, itinerary);
	}

	@DeleteMapping("/{itineraryId}")
	public void deleteItinerary(@PathVariable Long itineraryId) {
		itineraryRepositoryService.deleteItinerary(itineraryId);
	}

	@GetMapping("/{itineraryId}/places")
	public void getAllItineraryItems(@PathVariable Long itineraryId) {
		itineraryRepositoryService.getAllItineraryPlaces(itineraryId);
	}

	@PostMapping("/{itineraryId}/places")
	public void addPlaceToItinerary(@PathVariable Long itineraryId, @RequestBody PlaceDto place) {
		itineraryRepositoryService.addPlaceToItinerary(itineraryId, place);
	}

}
