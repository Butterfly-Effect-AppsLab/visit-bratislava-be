package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.Place;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/place")
public class PlaceRestController {

	@GetMapping("/")
	public Place getPlace() {
		return new Place("User", "testEmail");

	}

}
