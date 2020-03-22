package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;

import java.util.List;

public interface IItineraryRepositoryService {

	List<ItineraryDto> findAll();

}
