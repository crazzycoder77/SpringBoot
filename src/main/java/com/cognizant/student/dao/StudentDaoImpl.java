package com.cognizant.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.student.model.Student;

@Repository
@Qualifier("StudentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(Student s) {
		int row = jdbcTemplate.update("INSERT INTO student VALUES(?, ?, ?)", s.getId(), s.getName(), s.getMarks());
		if (row > 0)
			return true;
		return false;
	}

	public boolean update(Student student) {
		int row = jdbcTemplate.update("UPDATE student SET name=?, marks=? WHERE id=?", student.getName(), student.getMarks(), student.getId());
		if (row > 0)
			return true;
		return false;
	}
	
	public boolean delete(Student student) {
		int row = jdbcTemplate.update("DELETE FROM student WHERE id=?", student.getId());
		if (row > 0)
			return true;
		return false;	
	}
	public List<Student> getAll() {
		List<Student> students = jdbcTemplate.query("SELECT * FROM student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getFloat("marks"));
				return student;
			}});
		return students;
	}

	public Student getStudent(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",
        		new Object[]{id}, new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Student(
						        rs.getInt("id"),
						        rs.getString("name"),
						        rs.getFloat("marks")
						);
					}
				});
	}


}
