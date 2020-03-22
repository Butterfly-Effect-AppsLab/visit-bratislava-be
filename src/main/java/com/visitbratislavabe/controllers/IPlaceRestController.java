package com.visitbratislavabe.controllers;

import com.visitbratislavabe.services.utils.PlacesResponseWrapper;
import org.springframework.web.bind.annotation.GetMapping;

public interface IPlaceRestController {

	@GetMapping("/")
	PlacesResponseWrapper getAllPlaces();

}
