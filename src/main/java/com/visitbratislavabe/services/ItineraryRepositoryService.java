package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryRepositoryService implements IItineraryRepositoryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Override
	public List<ItineraryDto> getAllByCategory(String category) {
		return itineraryRepository.getAllByCategory(category);
	}

	@Override
	public ItineraryDto getById(long itineraryId) {
		return itineraryRepository.getById(itineraryId);
	}

	@Override
	public ItineraryDto save(ItineraryDto itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public long delete(long itineraryId) {
		return itineraryRepository.delete(itineraryId);
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public void getAllItineraryPlaces(long itineraryId) {
		itineraryRepository.findAll();
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public void addPlaceToItinerary(long itineraryId, PlaceDto place) {
		itineraryRepository.findAll();
	}

}
