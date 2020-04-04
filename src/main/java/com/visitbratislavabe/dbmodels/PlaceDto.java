package com.visitbratislavabe.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "places")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PlaceDto {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private long placeId;

	private String name;

	private String latitude;

	private String longitude;

	private String rating;

	private String website;

	private String address;

	private String image;

	private String locationString;

	private String rankingCategory;

	public PlaceDto() {
	}

	@ManyToMany(mappedBy = "places")
	Set<ItineraryDto> itineraries;

}
