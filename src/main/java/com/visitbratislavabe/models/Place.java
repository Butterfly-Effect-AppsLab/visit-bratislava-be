package com.visitbratislavabe.models;

import javax.persistence.Entity;

@Entity
public class Place implements IPlace {

	private String icon_url;

	private String id;

	private String url;

	private String value;

	@Override
    public String getIcon_url() {
		return icon_url;
	}

	@Override
    public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	@Override
    public String getId() {
		return id;
	}

	@Override
    public void setId(String id) {
		this.id = id;
	}

	@Override
    public String getUrl() {
		return url;
	}

	@Override
    public void setUrl(String url) {
		this.url = url;
	}

	@Override
    public String getValue() {
		return value;
	}

	@Override
    public void setValue(String value) {
		this.value = value;
	}

}
