package com.spring.dao.implementation;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper; 

import java.util.List;
import com.spring.dao.StudentDao;
import com.spring.entities.Student;

public class StudentDaoImplementation implements StudentDao{
	private JdbcTemplate jdbctemplate;
	public int insert(Student student) {
		String query = "insert into student(id,name,city) value(?,?,?)";
		int update = this.jdbctemplate.update(query,student.getId(),student.getName(),student.getCity());
		
	return update;
	}
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	public int update(Student student) {
		String query = "update student set name=?,city=? where id=?";
		int update = this.jdbctemplate.update(query,student.getName(),student.getCity(),student.getId());
		return update;
	}
	public int delete(int studentid) {
		String query = "delete from student where id=?";
		int result =this.jdbctemplate.update(query,studentid);
		return result;
	}
	public Student getStudent(int studentid) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		Student student = this.jdbctemplate.queryForObject(query, rowMapper,studentid);
		return student ;
	}
	public List<Student> getStudent() {
		String query= "select * from student";
		RowMapper<Student> rowMapper = new RowMapperImplementation();
		List<Student> student = this.jdbctemplate.query(query,rowMapper);  
		return student;
	}

}
