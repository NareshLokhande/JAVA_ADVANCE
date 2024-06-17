package com.example.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstbootApplication.class, args);
		System.out.println("\nFirst Spring boot Project");
		
//		Department dept = context.getBean(Department.class);
//		dept.setId(101);
//		dept.setName("Sales");
//		dept.setBlock("A");
//		System.out.println(dept);
		
		Car c = context.getBean(Car.class);
		c.setBrand("Maruti suzuki");
		c.setName("Swift");
		c.run();
		
	}

}
