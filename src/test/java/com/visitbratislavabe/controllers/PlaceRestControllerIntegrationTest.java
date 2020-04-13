package com.visitbratislavabe.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visitbratislavabe.Application;
import com.visitbratislavabe.dbmodels.Place;
import com.visitbratislavabe.services.PlaceRepositoryService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class PlaceRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private PlaceRepositoryService placeRepositoryService;

	@BeforeAll
	public void seedDatabaseWithPlaces() {
		placeRepositoryService.saveAll(createListOfPlaces());
	}

	@Test
	public void givenPlaces_whenGetPlacesByCategory_thenStatus200() throws Exception {
		mvc.perform(get("/api/places?category=attraction").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].category", is("attraction")));
	}

	@Test
	public void givenPlaces_whenPostPlaces_thenStatus200() throws Exception {
		List<Place> listOfPlaces = createListOfPlaces();
		mvc.perform(post("/api/places").content(asJsonString(listOfPlaces)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].name", is("mockName")));
	}

	@Test
	public void givenPlaces_whenGetPlaceDetail_thenStatus200() throws Exception {
		List<Place> listOfPlaces = createListOfPlaces();
		mvc.perform(get("/api/places/1").content(asJsonString(listOfPlaces)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));
	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// TODO - refactor mock objects
	private List<Place> createListOfPlaces() {
		Place placeAttraction = new Place("mockName", "mockLatitude", "mockLongitude", "mockRating", "mockWebsite",
				"mockAddress", "mockImage", "mockLocationString", "attraction");
		Place placeRestaurant = new Place("mockName", "mockLatitude", "mockLongitude", "mockRating", "mockWebsite",
				"mockAddress", "mockImage", "mockLocationString", "restaurant");
		List<Place> listOfPlaces = new ArrayList<Place>();
		listOfPlaces.add(placeAttraction);
		listOfPlaces.add(placeRestaurant);
		return listOfPlaces;

	}

}
