package com.visitbratislavabe.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestUtils {

	public static List<Place> createListOfPlaces() {
		Place placeAttraction = new Place("mockName", "mockLatitude", "mockLongitude", "mockRating", "mockWebsite",
				"mockAddress", "mockImage", "mockLocationString", "attraction");
		Place placeRestaurant = new Place("mockName", "mockLatitude", "mockLongitude", "mockRating", "mockWebsite",
				"mockAddress", "mockImage", "mockLocationString", "restaurant");
		List<Place> listOfPlaces = new ArrayList<Place>();
		listOfPlaces.add(placeAttraction);
		listOfPlaces.add(placeRestaurant);
		return listOfPlaces;
	}

	public static List<Itinerary> createListOfItineraries() {
		Itinerary itineraryRecommended = new Itinerary("mockDescription", "mockImage", "recommended",
				new HashSet<Place>());
		Itinerary itineraryPrivate = new Itinerary("mockDescription", "mockImage", "private", new HashSet<Place>());
		List<Itinerary> listOfItineraries = new ArrayList<Itinerary>();
		listOfItineraries.add(itineraryRecommended);
		listOfItineraries.add(itineraryPrivate);
		return listOfItineraries;
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
