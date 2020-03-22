package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.UserDto;
import com.visitbratislavabe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryService implements IUserRepositoryService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto save(UserDto user) {
		return userRepository.save(user);
	}

	@Override
	public UserDto findById(Long userId) {
		return userRepository.findById(userId).get();
	}

}
