package com.visitbratislavabe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long id;

	private String email;

	private String username;

	@OneToMany
	private List<Itinerary> itineraries;

	@OneToMany
	private List<Place> places;

	public User() {
	}

}
