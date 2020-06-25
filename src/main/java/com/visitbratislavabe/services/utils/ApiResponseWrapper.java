package com.visitbratislavabe.services.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseWrapper {

	private boolean success;

	private String message;

	public ApiResponseWrapper(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

}
