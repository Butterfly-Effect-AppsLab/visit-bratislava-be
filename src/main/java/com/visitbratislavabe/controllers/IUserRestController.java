package com.visitbratislavabe.controllers;

import com.visitbratislavabe.models.User;

public interface IUserRestController {
    User getUserDetail(Long userId);

    User createNewUser(User user);
}
