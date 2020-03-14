package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.services.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserRepositoryService userRepositoryService;

	@GetMapping("/user/{userId}")
	public User getUserDetail(@PathVariable Long userId) {
		return userRepositoryService.findById(userId);
	}

	@PostMapping("/create")
	public User newUser(@RequestBody User user) {
		return userRepositoryService.save(user);
	}

}
