package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.ItineraryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<ItineraryDto, Long> {

	@Query(value = "SELECT * FROM itineraries WHERE category = ?1", nativeQuery = true)
	List<ItineraryDto> getAllByCategory(String category);

	@Query(value = "SELECT * FROM itineraries WHERE itinerary_id = ?1", nativeQuery = true)
	ItineraryDto getById(long itineraryId);

	@Query(value = "DELETE FROM itineraries WHERE itinerary_id = ?1", nativeQuery = true)
	long delete(long itineraryId);

}
