package com.example.javabasedconfigdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.javabasedconfigdemo")

public class ApplicationConfig {
	
//	@Bean
//	public SamsungPhone getPhone() {
//		return new SamsungPhone();
//	}
//	
//	@Bean
//	public Processor getProcessor() {
//		return new Snapdragon();
//	}
	
}
