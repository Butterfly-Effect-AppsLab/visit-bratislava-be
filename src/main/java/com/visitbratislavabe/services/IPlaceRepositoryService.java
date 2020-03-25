package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.PlaceDto;

import java.util.List;

public interface IPlaceRepositoryService {

	List<PlaceDto> getAllByCategory(String category);

}
