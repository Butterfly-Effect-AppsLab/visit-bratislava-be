package com.visitbratislavabe.config;

import com.visitbratislavabe.handlers.FailureHandler;
import com.visitbratislavabe.handlers.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SuccessHandler successHandler;

	@Autowired
	private FailureHandler failureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().antMatcher("/**").authorizeRequests().antMatchers("/").permitAll().anyRequest()
				.authenticated().and().oauth2Login().successHandler(successHandler).failureHandler(failureHandler);
	}

}
