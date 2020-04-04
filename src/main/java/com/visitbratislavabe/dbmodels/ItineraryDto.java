package com.visitbratislavabe.dbmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "itineraries")
@Getter
@Setter
public class ItineraryDto {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private long itineraryId;

	private String category;

	@ManyToMany
	@JoinTable(name = "place_itinerary", joinColumns = @JoinColumn(name = "itineraryId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	private Set<PlaceDto> places;

}