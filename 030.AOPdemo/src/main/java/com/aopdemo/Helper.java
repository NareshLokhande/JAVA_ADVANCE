package com.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Helper {
	
 
	//@Before("execution(public void Operations.operate())")	//=> It will call ccc for public void operate() which is in Operations class
	
	//@Before("execution(public void operate())")		=> It will call ccc for every public void operate()
	
	//@Before("execution(public * *(..))")	// => It will call ccc for all the public methods in the application
	
	//@Before("execution(public * Operations.*(..))")	// => It will call ccc for all the public methods in the application
	
	@Before("execution(* Operations.*(..))")	// => Pick all the methods in operation class
	public void sendNotification() {
		System.out.println("Notification sent !");
	}
	
	@After("execution(public void operate())")
	public void sendEmail() {
		System.out.println("Email sent !");
	}
	
	@Around("execution(public void operate())")
	public void logDetails(ProceedingJoinPoint jp) {
		System.out.println("Logging before operate..");
		
		// Operate() will be initiated
		try {
			jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("Logging after operate..");
	}
}
