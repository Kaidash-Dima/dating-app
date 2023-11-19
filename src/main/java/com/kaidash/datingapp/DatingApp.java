package com.kaidash.datingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DatingApp {

	public static void main(String[] args) {
		SpringApplication.run(DatingApp.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/**") // Allow URL patterns. /** means all endpoints in the application.
						.allowedOriginPatterns("*") // Origins that are allowed to access.
						.allowedMethods("GET", "POST", "PUT", "DELETE") // HTTP methods that are allowed. Add or remove as per your need.
						.allowCredentials(true)
						.allowedHeaders("*") // Allow all headers.
						.exposedHeaders("header1", "header2", "header3")
						.maxAge(3600); // Cache the CORS configuration for 1 hour.
			}
		};
	}
}

