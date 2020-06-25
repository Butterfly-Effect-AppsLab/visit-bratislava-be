package com.visitbratislavabe.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {

	public static List<Place> createListOfPlaces() {
		Place placeAttraction = new Place();
		placeAttraction.setName("mockName");
		placeAttraction.setLatitude("mockLatitude");
		placeAttraction.setLongitude("mockLongitude");
		placeAttraction.setRating("mockRating");
		placeAttraction.setWebsite("mockWebsite");
		placeAttraction.setAddress("mockAddress");
		placeAttraction.setImage("mockImage");
		placeAttraction.setLocationString("mockLocationString");
		placeAttraction.setCategory("attraction");

		Place placeRestaurant = new Place();
		placeRestaurant.setName("mockName");
		placeRestaurant.setLatitude("mockLatitude");
		placeRestaurant.setLongitude("mockLongitude");
		placeRestaurant.setRating("mockRating");
		placeRestaurant.setWebsite("mockWebsite");
		placeRestaurant.setAddress("mockAddress");
		placeRestaurant.setImage("mockImage");
		placeRestaurant.setLocationString("mockLocationString");
		placeRestaurant.setCategory("restaurant");
		List<Place> listOfPlaces = new ArrayList<>();
		listOfPlaces.add(placeAttraction);
		listOfPlaces.add(placeRestaurant);
		return listOfPlaces;
	}

	public static List<Itinerary> createListOfItineraries() {
		Itinerary itineraryRecommended = new Itinerary();
		itineraryRecommended.setDescription("mockDescription");
		itineraryRecommended.setImage("mockImage");
		itineraryRecommended.setCategory("recommended");
		itineraryRecommended.setPlaces(new HashSet<>());
		Itinerary itineraryPrivate = new Itinerary();
		itineraryPrivate.setDescription("mockDescription");
		itineraryPrivate.setImage("mockImage");
		itineraryPrivate.setCategory("private");
		itineraryPrivate.setPlaces(new HashSet<>());
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

	public static <T> Set<T> convertToSet(List<T> list) {
		Set<T> set = new HashSet<T>();
		list.forEach(element -> set.add(element));
		return set;
	}

}
