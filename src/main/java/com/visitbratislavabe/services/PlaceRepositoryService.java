package com.visitbratislavabe.services;

import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceRepositoryService implements IPlaceRepositoryService {

	@Autowired
	PlaceRepository placeRepository;

	public Place getById(long placeId) {
		return placeRepository.getById(placeId);
	}

	public List<Place> saveAll(List<Place> places) {
		return placeRepository.saveAll(places);
	}

	public List<Place> getByCategory(String category) {
		return placeRepository.getByCategory(category);
	}

}
