package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.User;
import com.visitbratislavabe.services.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserRepositoryService userService;

	@PostMapping("")
	public User createNewUser(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping("/{userId}")
	public User getUserDetail(@PathVariable long userId) {
		return userService.getById(userId);
	}

}
