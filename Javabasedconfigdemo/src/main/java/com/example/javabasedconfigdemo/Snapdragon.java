package com.example.javabasedconfigdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("snapdragon")
public class Snapdragon implements Processor {
	
	@Override
	public void process() {
		System.out.println("Snapdragon Processor");
	}
}
