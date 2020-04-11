package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.Place;

import java.util.List;

public interface IPlaceRepositoryService {

	List<Place> getByCategory(String category);

}
