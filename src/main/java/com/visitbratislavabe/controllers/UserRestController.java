package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.UserDto;
import com.visitbratislavabe.services.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	IUserRepositoryService userService;

	@GetMapping("/user/{userId}")
	public UserDto getUserDetail(@PathVariable Long userId) {
		return userService.findById(userId);
	}

	@PostMapping("/create")
	public UserDto newUser(@RequestBody UserDto user) {
		return userService.save(user);
	}

}
