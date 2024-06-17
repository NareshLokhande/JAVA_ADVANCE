package com.example.springbootmyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class mywebApplication {

	public static void main(String[] args) {

		SpringApplication.run(mywebApplication.class, args);
		System.out.println("\nSpring boot Project started ....");

	}

}
