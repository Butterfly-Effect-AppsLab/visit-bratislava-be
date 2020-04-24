package com.visitbratislavabe.services.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseWrapper {

    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponseWrapper(String accessToken) {
        this.accessToken = accessToken;
    }

}
