package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryRepository extends CrudRepository<ItineraryDto, Long> {

}
