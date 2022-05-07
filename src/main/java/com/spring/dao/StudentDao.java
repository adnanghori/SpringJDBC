package com.spring.dao;

import java.util.List;

import com.spring.entities.Student;

public interface StudentDao {
	public int  insert(Student student);
	public int update(Student student);
	public int delete(int studentid);
	public Student getStudent(int studentid);
	public List <Student> getStudent();
}	
  