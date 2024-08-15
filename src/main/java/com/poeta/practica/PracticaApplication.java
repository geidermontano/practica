package com.poeta.practica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticaApplication {

	private static final Logger logger = LoggerFactory.getLogger(PracticaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PracticaApplication.class, args);
		logger.info("Swagger UI available at http://localhost:8080/api/v1");
	}

}
