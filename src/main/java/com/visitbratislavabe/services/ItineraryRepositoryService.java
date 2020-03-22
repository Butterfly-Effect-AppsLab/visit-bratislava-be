package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryRepositoryService implements IItineraryRepositoryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Override
	public Iterable<ItineraryDto> getItineraries(String category) {
		return itineraryRepository.findAll();
	}

	@Override
	public ItineraryDto getItinerary(Long itineraryId) {
		return itineraryRepository.findById(itineraryId).get();
	}

	@Override
	public ItineraryDto saveItinerary(ItineraryDto itinerary) {
		return itineraryRepository.save(itinerary);
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public ItineraryDto updateItinerary(Long itineraryId, ItineraryDto itinerary) {
		return itineraryRepository.findById(itineraryId).get();
	}

	@Override
	public void deleteItinerary(Long itineraryId) {
		itineraryRepository.deleteById(itineraryId);
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public void getAllItineraryPlaces(Long itineraryId) {
		itineraryRepository.findAll();
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public void addPlaceToItinerary(Long itineraryId, PlaceDto place) {
		itineraryRepository.findAll();
	}

}
