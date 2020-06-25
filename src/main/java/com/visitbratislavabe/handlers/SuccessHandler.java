package com.visitbratislavabe.handlers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.services.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
		String userName = (String) userDetails.getAttributes().get("name");
		String userEmail = (String) userDetails.getAttributes().get("email");

		if(userRepository.getByEmail(userEmail) == null) {
			User newUser = new User();
			newUser.setName(userName);
			newUser.setEmail(userEmail);
			userRepository.save(newUser);
		}

		response.sendRedirect("http://localhost:3000/");
	}

}
