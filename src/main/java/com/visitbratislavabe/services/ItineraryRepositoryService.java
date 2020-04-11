package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.Itinerary;
import com.visitbratislavabe.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryRepositoryService implements IItineraryRepositoryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Override
	public List<Itinerary> getAllByCategory(String category) {
		return itineraryRepository.getAllByCategory(category);
	}

	@Override
	public Itinerary getById(long itineraryId) {
		return itineraryRepository.getById(itineraryId);
	}

	@Override
	public Itinerary save(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public long delete(long itineraryId) {
		return itineraryRepository.delete(itineraryId);
	}

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public Itinerary update(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public void addPlace(long itineraryId, long placeId) {
		itineraryRepository.addPlace(itineraryId, placeId);
	}

	@Override
	public void removePlace(long itineraryId, long placeId) {
		itineraryRepository.removePlace(itineraryId, placeId);
	};

	// TODO this method is just a template it will use different submethod and return
	// value in the future
	@Override
	public void getAllItineraryPlaces(long itineraryId) {
		itineraryRepository.findAll();
	}

}
