package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@GetMapping("/me")
	public User currentUser() {
		return new User(UUID.randomUUID(), "mockEmail", "mockName", "mockLastname");
	}

}
