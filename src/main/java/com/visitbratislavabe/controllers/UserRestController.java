package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.utils.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @GetMapping("/me")
    public UserDto currentUser() {
        User user = new User(UUID.randomUUID(), "mockEmail", "mockName", "mockLastname");
        return UserDto.fromUser(user);
    }
}
