package com.visitbratislavabe.dbmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long id;

	private String email;

	private String username;

	public User() {
	}

}
