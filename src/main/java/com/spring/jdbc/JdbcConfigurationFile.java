package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.implementation.StudentDaoImplementation;
import com.spring.entities.Student;

@Configuration 
public class JdbcConfigurationFile {
  @Bean("datasource") 
  public AbstractDataSource getDataSouce(){
	  	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	  	dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springjdbc");
	  	dataSource.setUsername("root");
	  	dataSource.setPassword("Macbookair03");
	  	return dataSource;
  }
  @Bean("jdbctemplate")
  public JdbcTemplate getJdbcTemplate() {
	  JdbcTemplate jdbcTemplate = new JdbcTemplate();
	  jdbcTemplate.setDataSource(getDataSouce());
	return jdbcTemplate;
	   
  }
  @Bean("studentdao")
  public StudentDaoImplementation getStudentDao() {
	  StudentDaoImplementation studentDaoImplementation = new StudentDaoImplementation();
	  studentDaoImplementation.setJdbctemplate(getJdbcTemplate());
	  return studentDaoImplementation; 
  }
  @Bean("student")
  public Student getStudent() {
	  Student student = new Student();
	  return student;
  }
}
