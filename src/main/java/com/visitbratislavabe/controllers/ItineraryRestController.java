package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.services.ItineraryRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryRestController {

	@Autowired
	ItineraryRepositoryService itineraryRepositoryService;

	@GetMapping("/")
	public List<ItineraryDto> getRecommended() {
		return itineraryRepositoryService.getRecommended();
	}

}
