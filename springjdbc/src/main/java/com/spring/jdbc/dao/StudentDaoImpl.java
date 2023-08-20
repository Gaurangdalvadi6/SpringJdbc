package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student (id,name,city) values(?,?,?)";
		int i = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return i;
	}

	public int changes(Student student) {
		// TODO Auto-generated method stub
		String query = "update student set name=?,city=? where id=?";
		int i = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return i;
	}

	
	

	public int delete(int id) {
		// TODO Auto-generated method stub
		String query = "delete from student where id=?";
		int i = this.jdbcTemplate.update(query,id);
		return i;
	}
	
	public Student getStudent(int id) {
		// select single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, id);
		return student;
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
}
