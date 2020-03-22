package com.visitbratislavabe.controllers;

import com.visitbratislavabe.dbmodels.UserDto;

public interface IUserRestController {

	UserDto getUserDetail(Long userId);

	UserDto createNewUser(UserDto user);

}
