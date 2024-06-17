package com.example.springbootdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Department {
	private int id;
	private String name;
	private String block;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", block=" + block + "]";
	}
	
	
}
