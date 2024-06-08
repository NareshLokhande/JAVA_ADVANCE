package com.personcrud.dao;

import java.util.List;

import com.personcrud.models.Person;

public interface PersonDAO {

	int save(Person person);
	List<Person> getall();
	Person getByID(int id);
	int remove(int id);
	int update(int id, Person person);
	
}
