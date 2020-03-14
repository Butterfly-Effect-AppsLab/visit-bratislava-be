package com.visitbratislavabe.services;

import com.visitbratislavabe.models.Place;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlaceApiService implements IPlaceApiService {

	private RestTemplate restTemplate;

	public String placesApiUrl = "https://api.chucknorris.io/jokes/random";

	public PlaceApiService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
    public Place getRandomPlace() {
		return this.restTemplate.getForObject(placesApiUrl, Place.class);
	}

}
