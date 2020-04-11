package com.visitbratislavabe.repositories;

import com.visitbratislavabe.dbmodels.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	@Query(value = "SELECT * FROM itinerary WHERE category = ?1", nativeQuery = true)
	List<Itinerary> getAllByCategory(String category);

	@Query(value = "SELECT * FROM itinerary WHERE id = ?1", nativeQuery = true)
    Itinerary getById(long itineraryId);

	@Query(value = "DELETE FROM itinerary WHERE id = ?1", nativeQuery = true)
	long delete(long itineraryId);

	@Query(value = "INSERT INTO itinerary_places (itinerary_id, place_id) VALUES (?1, ?2)", nativeQuery = true)
	void addPlace(long itineraryId, long placeId);

	@Query(value = "DELETE FROM itinerary_places WHERE itinerary_id = ?1 AND place_id = ?2", nativeQuery = true)
	void removePlace(long itineraryId, long placeId);

}
