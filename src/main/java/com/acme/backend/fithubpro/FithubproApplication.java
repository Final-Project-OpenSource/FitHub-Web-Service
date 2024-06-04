package com.acme.backend.fithubpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FithubproApplication {

	public static void main(String[] args) {
		SpringApplication.run(FithubproApplication.class, args);
	}

}
