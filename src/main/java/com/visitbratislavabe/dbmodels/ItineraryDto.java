package com.visitbratislavabe.dbmodels;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "itineraries")
public class ItineraryDto {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long itineraryId;

	private boolean recommended = true;

	@ManyToMany
	@JoinTable(name = "place_like", joinColumns = @JoinColumn(name = "itineraryId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	private Set<PlaceDto> places;

}