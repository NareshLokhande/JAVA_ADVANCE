package com.personcrud.models;

import java.sql.Date;

public class Person {
	private int id_person;
	private String name_person;
	private Date dob;
	
	//Constructor
	public Person() {}

	public Person(int id_person, String name_person, Date dob) {
		super();
		this.id_person = id_person;
		this.name_person = name_person;
		this.dob = dob;
	}

	// Getter And Setters
	public int getId_person() {
		return id_person;
	}

	public void setId_person(int id_person) {
		this.id_person = id_person;
	}

	public String getName_person() {
		return name_person;
	}

	public void setName_person(String name_person) {
		this.name_person = name_person;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
