package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.Itinerary;

import java.util.List;

public interface IItineraryRepositoryService {

	List<Itinerary> getAllByCategory(String category);

	Itinerary getById(long itineraryId);

	Itinerary save(Itinerary itinerary);

	Itinerary update(Itinerary itinerary);

	long deleteById(long itineraryId);

	void getAllItineraryPlaces(long itineraryId);

}
