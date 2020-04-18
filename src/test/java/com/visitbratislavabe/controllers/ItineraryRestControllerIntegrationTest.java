package com.visitbratislavabe.controllers;

import com.visitbratislavabe.Application;
import com.visitbratislavabe.models.Itinerary;
import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.services.ItineraryRepositoryService;
import com.visitbratislavabe.services.PlaceRepositoryService;
import com.visitbratislavabe.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class ItineraryRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ItineraryRepositoryService itineraryRepositoryService;

	@Autowired
	private PlaceRepositoryService placeRepositoryService;

	long mockItineraryId;

	List<Place> listOfPlaces;

	@Before
	public void seedDatabaseWithPlaces() {
		listOfPlaces = placeRepositoryService.saveAll(TestUtils.createListOfPlaces());
		mockItineraryId = itineraryRepositoryService.save(TestUtils.createListOfItineraries().get(0)).getId();
		itineraryRepositoryService.save(TestUtils.createListOfItineraries().get(1));
	}

	@Test
	public void givenItinerary_whenPostItinerary_thenStatus200() throws Exception {
		Itinerary itinerary = TestUtils.createListOfItineraries().get(0);
		mvc.perform(post("/api/itineraries").content(TestUtils.asJsonString(itinerary))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.description", is("mockDescription")));
	}

	@Test
	public void givenItinerary_whenGetItinerariesByCategory_thenStatus200() throws Exception {
		mvc.perform(get("/api/itineraries?category=recommended").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$").isArray());
	}

	@Test
	public void givenItineraryId_whenGetItineraryDetail_thenStatus200() throws Exception {
		mvc.perform(get("/api/itineraries/" + mockItineraryId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	// TODO - this test does not work properly, need better mocks
	@Test
	public void givenItinerary_whenPutItineraryByCategory_thenStatus200() throws Exception {
		Itinerary itinerary = new Itinerary("newDescription", "newImage", "newCategory", new HashSet<Place>());
		mvc.perform(put("/api/itineraries").content(TestUtils.asJsonString(itinerary))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void givenItinerary_whenDeleteItinerary_thenStatus200() throws Exception {
		mvc.perform(delete("/api/itineraries/" + mockItineraryId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void givenItinerary_whenGetItineraryPlaces_thenStatus200() throws Exception {
		mvc.perform(get("/api/itineraries/" + mockItineraryId + "/places").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	public void givenItinerary_whenAddPlacesToItinerary_thenStatus200() throws Exception {
		mvc.perform(post("/api/itineraries/" + mockItineraryId + "/places")
				.content(TestUtils.asJsonString(listOfPlaces)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("mockName")));
	}

	@Test
	public void givenItinerary_whenDeletePlacesFromItineraryByCategory_thenStatus200() throws Exception {
		mvc.perform(delete("/api/itineraries/" + mockItineraryId + "/places")
				.content(TestUtils.asJsonString(listOfPlaces)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
