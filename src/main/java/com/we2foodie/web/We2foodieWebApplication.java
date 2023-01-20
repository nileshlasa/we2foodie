package com.we2foodie.web;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class We2foodieWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(We2foodieWebApplication.class, args);
	}

	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
