package com.visitbratislavabe.models;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class User implements IUser {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long userId;

	private String email;

	private String username;

	private String password;

	public User() {
	}

	public User(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
    public Long getId() {
		return userId;
	}

	@Override
    public String getEmail() {
		return email;
	}

	@Override
    public String getUsername() {
		return username;
	}

}
