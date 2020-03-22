package com.visitbratislavabe.dbmodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "places")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDto implements IPlaceDto {

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

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getLatitude() {
		return latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String getLongitude() {
		return longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String getLocationString() {
		return locationString;
	}

	@Override
	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	@Override
	public String getRankingCategory() {
		return rankingCategory;
	}

	@Override
	public void setRankingCategory(String rankingCategory) {
		this.rankingCategory = rankingCategory;
	}

	@Override
	public String getRating() {
		return rating;
	}

	@Override
	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String getWebsite() {
		return website;
	}

	@Override
	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getImageUrl() {
		return image;
	}

	@Override
	public void setImageUrl(String imageUrl) {
		this.image = imageUrl;
	}

	public PlaceDto() {
	}

	@ManyToMany(mappedBy = "places")
	Set<ItineraryDto> itineraries;

}
