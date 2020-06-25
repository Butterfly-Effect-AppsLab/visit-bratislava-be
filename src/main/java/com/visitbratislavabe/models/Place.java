package com.visitbratislavabe.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}
