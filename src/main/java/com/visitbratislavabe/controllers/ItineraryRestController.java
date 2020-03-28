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

	@GetMapping("")
	public List<ItineraryDto> getAllByCategory(@RequestParam String category) {
		return itineraryRepositoryService.getAllByCategory(category);
	}

	@PostMapping("")
	public ItineraryDto createNew(@RequestBody ItineraryDto itinerary) {
		return itineraryRepositoryService.save(itinerary);
	}

	@GetMapping("/{itineraryId}")
	public ItineraryDto getItinerary(@PathVariable long itineraryId) {
		return itineraryRepositoryService.getById(itineraryId);
	}

	@DeleteMapping("/{itineraryId}")
	public void deleteItinerary(@PathVariable long itineraryId) {
		itineraryRepositoryService.delete(itineraryId);
	}

	@GetMapping("/{itineraryId}/places")
	public void getAllItineraryItems(@PathVariable long itineraryId) {
		itineraryRepositoryService.getAllItineraryPlaces(itineraryId);
	}

	@PostMapping("/{itineraryId}/places")
	public void addPlaceToItinerary(@PathVariable long itineraryId, @RequestBody PlaceDto place) {
		itineraryRepositoryService.addPlaceToItinerary(itineraryId, place);
	}

}
