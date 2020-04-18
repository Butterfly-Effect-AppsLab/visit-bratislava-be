package com.visitbratislavabe.services;

import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
	public void deleteById(long itineraryId) {
		itineraryRepository.deleteById(itineraryId);
	}

	@Override
	public Itinerary update(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	@Override
	public Set<Place> getAllItineraryPlaces(long itineraryId) {
		Itinerary itinerary = itineraryRepository.getById(itineraryId);
		return itinerary.getPlaces();
	}

	@Override
	public void removePlaces(long itineraryId, List<Place> placesToRemove) {
		Itinerary itinerary = itineraryRepository.getById(itineraryId);
		itinerary.removePlaces(placesToRemove);
		itineraryRepository.save(itinerary);
	}

	@Override
	public Set<Place> addPlaces(long itineraryId, List<Place> places) {
		Itinerary itinerary = itineraryRepository.getById(itineraryId);
		itinerary.addPlaces(places);
		itineraryRepository.save(itinerary);
		return itinerary.getPlaces();
	}

}
