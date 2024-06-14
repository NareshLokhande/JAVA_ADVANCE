package com.example.javabasedconfigdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SamsungPhone {
	
	@Autowired
	@Qualifier("snapdragon")
	Processor processor;
	
	public void specs() {
		System.out.println("Specs :\nRam = 8GB \nScreen = Amoled 6.4 inch ");
		processor.process();
	}
}
