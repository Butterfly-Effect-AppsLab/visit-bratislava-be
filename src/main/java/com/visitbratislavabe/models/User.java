package com.visitbratislavabe.models;

import java.util.UUID;

public class User implements IUser {

	private UUID id;

	private String email;

	private String firstName;

	private String lastName;

	public User(UUID id, String email, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
