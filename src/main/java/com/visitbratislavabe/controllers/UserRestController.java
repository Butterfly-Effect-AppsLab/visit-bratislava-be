package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserService userService;

	@GetMapping("/user/{userId}")
	public User saveUser(@PathVariable Long userId) {
		return userService.getOne(userId);
	}

	@PostMapping("/create")
	public User newUser(@RequestBody User user) {
		return userService.save(user);
	}

}
