package com.visitbratislavabe.dbmodels;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "itineraries")
public class ItineraryDto implements IItineraryDto {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long itineraryId;

	@ManyToMany
	@JoinTable(name = "place_like", joinColumns = @JoinColumn(name = "itineraryId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	private Set<PlaceDto> places;

}
