package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.PlaceDto;
import com.visitbratislavabe.services.utils.PlacesResponseWrapper;

import java.util.List;

public interface IPlaceApiService {

	List<PlaceDto> getAllPlaces();

}
