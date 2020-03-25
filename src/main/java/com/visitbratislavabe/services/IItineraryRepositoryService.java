package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;

import java.util.List;

public interface IItineraryRepositoryService {

	List<ItineraryDto> getAllByCategory(String category);

	ItineraryDto getById(long itineraryId);

	ItineraryDto save(ItineraryDto itinerary);

	long delete(long itineraryId);

	void getAllItineraryPlaces(long itineraryId);

	void addPlaceToItinerary(long itineraryId, PlaceDto place);

}
