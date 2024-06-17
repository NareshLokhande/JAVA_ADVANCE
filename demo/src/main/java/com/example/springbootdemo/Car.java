package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private String name;
	private String brand;

	@Autowired
	private Engine engine;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", brand=" + brand + "]";
	}

	public void run() {
		System.out.println(brand + " " + name + " is running with engine : " + engine);
	}
}
