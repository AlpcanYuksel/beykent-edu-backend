package com.beykent;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeykentEduBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeykentEduBackendApplication.class, args);
	}

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
