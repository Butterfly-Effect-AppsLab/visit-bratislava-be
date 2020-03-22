package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;

public interface IItineraryRepositoryService {

	Iterable<ItineraryDto> getItineraries(String category);

	ItineraryDto getItinerary(Long itineraryId);

	ItineraryDto saveItinerary(ItineraryDto itinerary);

	void getAllItineraryPlaces(Long itineraryId);

	void addPlaceToItinerary(Long itineraryId, PlaceDto place);

}
