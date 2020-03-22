package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import com.visitbratislavabe.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryRepositoryService implements IItineraryRepositoryService {

	@Autowired
	ItineraryRepository itineraryRepository;

	@Override
	public List<ItineraryDto> getRecommended() {
		return (List<ItineraryDto>) itineraryRepository.findAll();
	}

}
