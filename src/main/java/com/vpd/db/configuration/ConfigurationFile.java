package com.vpd.db.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vpd.db.service.JwtUserDetailsService; 

@Configuration
public class ConfigurationFile {
	@Bean
	PasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	} 
	
	@Bean
	JwtUserDetailsService getJwtUserDetailsService() {
		return new JwtUserDetailsService();
	} 
	
}
