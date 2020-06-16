package com.visitbratislavabe.services;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryService implements IUserRepositoryService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(long userId) {
		return userRepository.getById(userId);
	}

	@Override
	public User getByEmail(String userEmail) { return userRepository.getByEmail(userEmail); }

}
