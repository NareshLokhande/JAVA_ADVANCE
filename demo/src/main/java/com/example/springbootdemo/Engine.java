package com.example.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private int capacity;
	private int power;
	private int torque;
	
	public Engine() {
		capacity = 1500;
		power = 150;
		torque = 40;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getTorque() {
		return torque;
	}
	public void setTorque(int torque) {
		this.torque = torque;
	}
	@Override
	public String toString() {
		return "capacity=" + capacity + ", power=" + power + ", torque=" + torque;
	}
	
	
}
