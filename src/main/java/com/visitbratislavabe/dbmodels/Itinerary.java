package com.visitbratislavabe.dbmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

	private String image;

	private String category;

	@ManyToMany
	@JoinTable(name = "itinerary_places", joinColumns = @JoinColumn(name = "itinerary_id"),
			inverseJoinColumns = @JoinColumn(name = "place_id"))
	private Set<Place> places;

}