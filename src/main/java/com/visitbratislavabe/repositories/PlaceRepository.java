package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

	@Query(value = "SELECT * FROM places WHERE place_id = ?1", nativeQuery = true)
    Place getById(long placeId);

	@Query(value = "SELECT * FROM places WHERE ranking_category = ?1", nativeQuery = true)
	List<Place> getAllByCategory(String category);

}