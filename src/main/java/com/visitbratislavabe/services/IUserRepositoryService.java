package com.visitbratislavabe.services;

import com.visitbratislavabe.models.User;

public interface IUserRepositoryService {

	User save(User user);

	User getById(long userId);

}
