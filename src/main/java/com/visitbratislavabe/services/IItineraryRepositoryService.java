package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;

import java.util.List;

public interface IItineraryRepositoryService {

	List<ItineraryDto> getAllByCategory(String category);

	ItineraryDto getById(long itineraryId);

	ItineraryDto save(ItineraryDto itinerary);

	ItineraryDto update(ItineraryDto itinerary);

	long delete(long itineraryId);

	void getAllItineraryPlaces(long itineraryId);

	void addPlace(long itineraryId, long placeId);

	void removePlace(long itineraryId, long placeId);

}
