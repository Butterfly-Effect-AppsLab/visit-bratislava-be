package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	Place getById(long placeId);

	List<Place> getByCategory(String category);

}