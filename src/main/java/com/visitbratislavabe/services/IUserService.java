package com.visitbratislavabe.services;

import com.visitbratislavabe.models.User;

public interface IUserService {

	User save(User user);

	User findById(Long userId);

}