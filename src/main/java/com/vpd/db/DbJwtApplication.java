package com.vpd.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) 
public class DbJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbJwtApplication.class, args);
	}

}
