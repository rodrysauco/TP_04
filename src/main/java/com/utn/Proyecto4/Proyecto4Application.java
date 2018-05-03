package com.utn.Proyecto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Proyecto4Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto4Application.class, args);
	}
}
