package com.visitbratislavabe.services;

import com.visitbratislavabe.dbmodels.UserDto;

public interface IUserService {

	UserDto save(UserDto user);

	UserDto findById(Long userId);

}
