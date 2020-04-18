package com.visitbratislavabe.controllers;

import com.visitbratislavabe.Application;
import com.visitbratislavabe.models.Place;
import com.visitbratislavabe.services.PlaceRepositoryService;
import com.visitbratislavabe.utils.TestUtils;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

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
		placeRepositoryService.saveAll(TestUtils.createListOfPlaces());
	}

	@Test
	public void givenPlaces_whenGetPlacesByCategory_thenStatus200() throws Exception {
		mvc.perform(get("/api/places?category=attraction").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].category", is("attraction")));
	}

	@Test
	public void givenPlaces_whenPostPlaces_thenStatus200() throws Exception {
		List<Place> listOfPlaces = TestUtils.createListOfPlaces();
		mvc.perform(post("/api/places").content(TestUtils.asJsonString(listOfPlaces))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$[0].name", is("mockName")));
	}

	@Test
	public void givenPlaces_whenGetPlaceDetail_thenStatus200() throws Exception {
		List<Place> listOfPlaces = TestUtils.createListOfPlaces();
		mvc.perform(get("/api/places/1").content(TestUtils.asJsonString(listOfPlaces))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)));
	}

}
