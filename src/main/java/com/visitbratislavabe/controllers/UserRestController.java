package com.visitbratislavabe.controllers;

import com.visitbratislavabe.exception.ResourceNotFoundException;
import com.visitbratislavabe.models.User;
import com.visitbratislavabe.security.CurrentUser;
import com.visitbratislavabe.security.UserPrincipal;
import com.visitbratislavabe.services.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@GetMapping("/me")
	@PreAuthorize("hasRole('USER')")
	public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		User currentUser = userService.getById(userPrincipal.getId());

		if(currentUser == null) {
			throw new ResourceNotFoundException("User", "id", userPrincipal.getId());
		}

		return currentUser;
	}

}

