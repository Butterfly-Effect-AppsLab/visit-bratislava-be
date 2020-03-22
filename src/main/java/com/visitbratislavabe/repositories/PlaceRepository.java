package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.PlaceDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceDto, Long> {

}
