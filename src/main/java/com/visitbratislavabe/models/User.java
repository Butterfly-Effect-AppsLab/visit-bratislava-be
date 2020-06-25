package com.visitbratislavabe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Email;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long id;

	@Email
	private String email;

	@OneToMany
	private List<Itinerary> itineraries;

	@OneToMany
	private List<Place> places;

	@Column(nullable = false)
	private String name;

	private String imageUrl;

	public User() {
	}

}
