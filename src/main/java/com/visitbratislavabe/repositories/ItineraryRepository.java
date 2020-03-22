package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends CrudRepository<ItineraryDto, Long> {

}
