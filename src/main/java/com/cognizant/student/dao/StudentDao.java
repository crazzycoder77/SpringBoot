package com.cognizant.student.dao;

import java.util.List;

import com.cognizant.student.model.Student;

public interface StudentDao {
	public boolean insert(Student student);
	public boolean update(Student student);
	public boolean delete(Student student);
	public List<Student> getAll();
	public Student getStudent(int id);
}
