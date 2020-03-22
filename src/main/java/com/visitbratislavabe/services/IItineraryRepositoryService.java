package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.dbmodels.PlaceDto;

public interface IItineraryRepositoryService {

	Iterable<ItineraryDto> getItineraries(String category);

	ItineraryDto getItinerary(Long itineraryId);

	ItineraryDto saveItinerary(ItineraryDto itinerary);

	ItineraryDto updateItinerary(Long itineraryId, ItineraryDto itinerary);

	void deleteItinerary(Long itineraryId);

	void getAllItineraryPlaces(Long itineraryId);

	void addPlaceToItinerary(Long itineraryId, PlaceDto place);

}
