package com.visitbratislavabe.repositories;

import com.visitbratislavabe.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	List<Itinerary> getAllByCategory(String category);

	Itinerary getById(long itineraryId);

	void deleteById(long itineraryId);

}
