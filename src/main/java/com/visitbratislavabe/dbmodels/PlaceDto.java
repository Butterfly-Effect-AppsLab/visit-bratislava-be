package com.visitbratislavabe.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "places")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDto {

	@Id
	private Long placeId;

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

	@SuppressWarnings("unchecked")
	@JsonProperty("photo")
	private void unpackNested(Map<String, Object> photo) {
		this.imagesObject = (Map<String, Object>) photo.get("images");
		this.originalImage = (Map<String, Object>) imagesObject.get("original");
		this.image = (String) originalImage.get("url");
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public String getRankingCategory() {
		return rankingCategory;
	}

	public void setRankingCategory(String rankingCategory) {
		this.rankingCategory = rankingCategory;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return image;
	}

	public void setImageUrl(String imageUrl) {
		this.image = imageUrl;
	}

	public PlaceDto() {
	}

	// @ManyToMany(mappedBy = "places")
	// Set<ItineraryDto> itineraries;

}
