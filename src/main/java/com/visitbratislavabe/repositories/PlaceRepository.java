package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.PlaceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceDto, Long> {

	@Query(value = "SELECT * FROM places WHERE place_id = ?1", nativeQuery = true)
	PlaceDto getById(long placeId);

	@Query(value = "SELECT * FROM places WHERE ranking_category = ?1", nativeQuery = true)
	List<PlaceDto> getAllByCategory(String category);

}