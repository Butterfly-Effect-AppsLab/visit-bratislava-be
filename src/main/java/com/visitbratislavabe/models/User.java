package com.visitbratislavabe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long id;

	@Email
	private String email;

	private String username;

	@JsonIgnore
	private String password;

	@Column(nullable = false)
	private String name;

	private String imageUrl;

	public User() {
	}

}
