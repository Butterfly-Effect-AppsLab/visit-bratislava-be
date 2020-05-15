package com.visitbratislavabe.handlers;

import com.visitbratislavabe.models.User;
import com.visitbratislavabe.services.UserRepositoryService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
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

//	 @Autowired
//	 private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		DefaultOidcUser userDetails = (DefaultOidcUser) authentication.getPrincipal();
		if(userRepository.getByEmail(userDetails.getEmail()) != null) {
			User newUser = new User();
			newUser.setName(userDetails.getFullName());
			newUser.setEmail(userDetails.getEmail());
			newUser.setImageUrl(userDetails.getPicture());
			userRepository.save(newUser);
		}

//		 response.getWriter().write(objectMapper.writeValueAsString(authInfo));
//		 response.setContentType("application/json");
//		 response.setStatus(200);
	}

}
