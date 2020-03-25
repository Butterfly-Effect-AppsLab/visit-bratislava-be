package com.visitbratislavabe.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;
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

	@JsonProperty("location_string")
	private String locationString;

	@JsonProperty("ranking_category")
	private String rankingCategory;

	@Transient
	private Map<String, Object> imagesObject;

	@Transient
	private Map<String, Object> originalImage;

	// TODO: this part will be removed when database will be created
	@SuppressWarnings("unchecked")
	@JsonProperty("photo")
	private void unpackNested(Map<String, Object> photo) {
		this.imagesObject = (Map<String, Object>) photo.get("images");
		this.originalImage = (Map<String, Object>) imagesObject.get("original");
		this.image = (String) originalImage.get("url");
	};

	public PlaceDto() {
	}

	@ManyToMany(mappedBy = "places")
	Set<ItineraryDto> itineraries;

}
