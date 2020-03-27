package com.cognizant.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cognizant.student.dao.StudentDao;
import com.cognizant.student.model.Student;

@Service
@Qualifier("StudentService")
public class StudentService {
	@Autowired
	StudentDao studentDao;

	public boolean insert(Student student) {
		return studentDao.insert(student);
	}

	public boolean update(Student student) {
		return studentDao.update(student);
	}

	public boolean delete(int id) {
		return studentDao.delete(new Student(id));
	}
	public List<Student> getAll(){
		return studentDao.getAll();
	}
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}
	

}
