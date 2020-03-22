package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceRepositoryService implements IPlaceRepositoryService {

	@Autowired
	PlaceRepository placeRepository;

	@Override
	public Iterable<PlaceDto> saveAll(Iterable<PlaceDto> places) {
		return placeRepository.saveAll(places);
	}

}
