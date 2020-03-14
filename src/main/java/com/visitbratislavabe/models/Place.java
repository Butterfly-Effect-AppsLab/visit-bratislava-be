package com.visitbratislavabe.models;

public class Place {

	private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String name;

	private String email;

	public Place(String name, String email) {
		this.name = name;
		this.email = email;
	}

}
