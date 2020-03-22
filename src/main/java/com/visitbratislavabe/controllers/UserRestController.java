package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.UserDto;
import com.visitbratislavabe.services.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController implements IUserRestController {

	@Autowired
	IUserRepositoryService userRepositoryService;

	@GetMapping("/user/{userId}")
	public UserDto getUserDetail(@PathVariable Long userId) {
		return userRepositoryService.findById(userId);
	}

	@PostMapping("/create")
	public UserDto createNewUser(@RequestBody UserDto user) {
		return userRepositoryService.save(user);
	}

}
