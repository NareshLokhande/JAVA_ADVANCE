package com.example.javabasedconfigdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	// Use AnnotationConfigApplicationContext for Java-based configuration
    	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	
    	// Retrieve the bean from the context
    	SamsungPhone phone = context.getBean(SamsungPhone.class);
    	phone.specs();
    }
}
