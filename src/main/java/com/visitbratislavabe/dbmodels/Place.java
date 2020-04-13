package com.visitbratislavabe.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "place")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Place {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private long id;

	private String name;

	private String latitude;

	private String longitude;

	private String rating;

	private String website;

	private String address;

	private String image;

	private String locationString;

	private String category;

	public Place() {
	}

	public Place(String name, String latitude, String longitude, String rating, String website, String address,
			String image, String locationString, String category) {
		this.name = name;

		this.latitude = latitude;

		this.longitude = longitude;

		this.rating = rating;

		this.website = website;

		this.address = address;

		this.image = image;

		this.locationString = locationString;

		this.category = category;
	}

}
