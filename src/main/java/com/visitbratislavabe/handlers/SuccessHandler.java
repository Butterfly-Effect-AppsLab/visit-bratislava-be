package com.visitbratislavabe.handlers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.services.UserRepositoryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserRepositoryService userRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		DefaultOAuth2User userDetails = (DefaultOAuth2User) authentication.getPrincipal();
		if(userRepository.getByEmail((String) userDetails.getAttributes().get("email")) != null) {
			User newUser = new User();
			newUser.setName((String) userDetails.getAttributes().get("name"));
			newUser.setEmail((String) userDetails.getAttributes().get("email"));
			userRepository.save(newUser);
		}
	}

}
