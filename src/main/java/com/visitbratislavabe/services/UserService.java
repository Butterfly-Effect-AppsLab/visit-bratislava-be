package com.visitbratislavabe.services;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getOne(Long userId) {
		return userRepository.getOne(userId);
	}

}
