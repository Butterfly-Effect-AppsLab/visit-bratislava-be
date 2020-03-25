package com.visitbratislavabe.dbmodels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Getter
@Setter
public class UserDto {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "serial")
	private Long userId;

	private String email;

	private String username;

	public UserDto() {
	}

}
