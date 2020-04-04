package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceRepositoryService implements IPlaceRepositoryService {

	@Autowired
	PlaceRepository placeRepository;

	public PlaceDto getById(long placeId) {
		return placeRepository.getById(placeId);
	}

	public List<PlaceDto> saveAll(List<PlaceDto> places) {
		return placeRepository.saveAll(places);
	}

	public List<PlaceDto> getAllByCategory(String category) {
		return placeRepository.getAllByCategory(category);
	}

}
