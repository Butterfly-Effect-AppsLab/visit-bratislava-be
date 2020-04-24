package com.visitbratislavabe.services.utils;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequestWrapper {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;


}
