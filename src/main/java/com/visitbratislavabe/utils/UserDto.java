package com.visitbratislavabe.utils;

import com.visitbratislavabe.models.User;
import lombok.Value;

@Value
public class UserDto {

	private String firstName;

	private String lastName;

	private String email;

	public static UserDto fromUser(User user) {
		return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail());
	}

}
