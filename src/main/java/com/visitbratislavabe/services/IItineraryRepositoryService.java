package com.visitbratislavabe.services;

import com.visitbratislavabe.models.Itinerary;

import java.util.List;

public interface IItineraryRepositoryService {

	List<Itinerary> getAllByCategory(String category);

	Itinerary getById(long itineraryId);

	Itinerary save(Itinerary itinerary);

	Itinerary update(Itinerary itinerary);

	void deleteById(long itineraryId);

	void getAllItineraryPlaces(long itineraryId);

}
