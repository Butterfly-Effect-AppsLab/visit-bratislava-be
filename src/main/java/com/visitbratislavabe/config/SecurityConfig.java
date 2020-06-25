package com.visitbratislavabe.config;

import com.visitbratislavabe.handlers.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors()
				.and()
				.antMatcher("/**").authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/oauth2/**").permitAll()
				.anyRequest().authenticated()
				.and().oauth2Login().successHandler(successHandler)
				.failureUrl("http://localhost:3000/")
				.and().exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
	}

	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Arrays.asList("Origin", "Accept", "X-Requested-With", "Content-Type",
													"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
