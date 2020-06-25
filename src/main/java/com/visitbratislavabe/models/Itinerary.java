package com.visitbratislavabe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "itinerary")
@Getter
@Setter
public class Itinerary {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private long id;

	public long getId() {
		return id;
	}

	private String title;

	private String description;

	private String image;

	private String category;

	private String arrivalTime;

	private String departureTime;

	@ManyToMany
	@JoinTable(name = "itinerary_places", joinColumns = @JoinColumn(name = "itinerary_id"),
			inverseJoinColumns = @JoinColumn(name = "place_id"))
	private Set<Place> places;

	public Set<Place> getPlaces() {
		return places;
	}

	public void addPlaces(List<Place> placesToAdd) {
		placesToAdd.forEach(place -> places.add(place));
	}

	public void removePlaces(List<Place> places) {
		places.remove(places);
	}

	public Itinerary() {
	}

	public Itinerary(String title, String description, String image, String category, Set<Place> places) {
		this.title = title;
		this.description = description;
		this.image = image;
		this.category = category;
		this.places = places;
	}

}