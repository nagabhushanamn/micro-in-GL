package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableOAuth2Sso
public class CloudSecurityApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(CloudSecurityApplication.class, args);
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/","/items")
		.permitAll()
		.anyRequest()
		.authenticated();
	
	}
	
}
