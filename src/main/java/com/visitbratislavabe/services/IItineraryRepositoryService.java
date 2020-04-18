package com.visitbratislavabe.services;

import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public interface IItineraryRepositoryService {

	List<Itinerary> getAllByCategory(String category);

	Itinerary getById(long itineraryId);

	Itinerary save(Itinerary itinerary);

	Itinerary update(Itinerary itinerary);

	void deleteById(long itineraryId);

	Set<Place> getAllItineraryPlaces(long itineraryId);

	Set<Place> addPlaces(long itineraryId, List<Place> places);

	void removePlaces(long itineraryId, List<Place> placesToRemove);

}
