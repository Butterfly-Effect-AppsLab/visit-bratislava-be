package com.visitbratislavabe.services;

import com.visitbratislavabe.services.utils.PlacesResponseWrapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Service
public class PlaceApiService implements IPlaceApiService {

	private Client client = ClientBuilder.newClient();

	// TODO these variables should be stored as envs
	private String rapidApiBaseUrl = "https://tripadvisor1.p.rapidapi.com";

	private String rapidApiEndpoint = "/attractions/list";

	private String rapidApiKey = "953901cd22msh314cdf83fa1c496p16b2dajsn22ed06779b31";

	private String rapidApihost = "tripadvisor1.p.rapidapi.com";

	private String bratislavaLocationId = "274924";

	public PlaceApiService() {
	}

	@Override
	public PlacesResponseWrapper getAllPlaces() {
		return client.target(rapidApiBaseUrl).path(rapidApiEndpoint).queryParam("limit", "100")
				.queryParam("location_id", bratislavaLocationId).request().header("x-rapidapi-host", rapidApihost)
				.header("x-rapidapi-key", rapidApiKey).get(PlacesResponseWrapper.class);
	}

}
