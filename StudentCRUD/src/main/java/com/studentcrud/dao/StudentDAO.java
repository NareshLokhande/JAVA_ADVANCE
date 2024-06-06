package com.studentcrud.dao;

import java.util.List;

import com.studentcrud.models.Student;

public interface StudentDAO {

	int save(Student student);
	List<Student> getAll();
	Student getById(int id);
	int remove(int id);
	int update(int id, Student student);
}
