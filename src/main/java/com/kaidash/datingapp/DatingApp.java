package com.kaidash.datingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DatingApp {

	public static void main(String[] args) {
		SpringApplication.run(DatingApp.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Allow URL patterns. /** means all endpoints in the application.
						.allowedOrigins("*") // Origins that are allowed to access.
						.allowedMethods("GET", "POST", "PUT", "DELETE") // HTTP methods that are allowed. Add or remove as per your need.
						.allowCredentials(true)
						.allowedHeaders("*") // Allow all headers.
						.exposedHeaders("header1", "header2", "header3")
						.maxAge(3600); // Cache the CORS configuration for 1 hour.
			}
		};
	}
}

