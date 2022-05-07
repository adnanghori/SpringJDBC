package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.implementation.StudentDaoImplementation;
import com.spring.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
    	//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/configuration.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfigurationFile.class); 
//    	JdbcTemplate template = context.getBean("jdbctemplate",JdbcTemplate.class);
//    	String query = "insert into student(id,name,city) value(104,'Cleopatra','Indore')";
//    	int update = template.update(query);
//    	 System.out.println("Rows affected"+update);
//    	 String second_query = "insert into student(id,name,city) value(?,?,?)";
//    	 template.update(second_query,105,"Bubu","Indore");
//    	 System.out.println("done");
    	StudentDaoImplementation studentdao = context.getBean("studentdao",StudentDaoImplementation.class);
    	Student student = context.getBean("student",Student.class);
//    	student.setId(106);
//    	student.setName("Vedant");
//    	student.setCity("Indore");
//    	int update = studentdao.insert(student);
//    	System.out.println(update);
//    	student.setName("Tweety");
//    	student.setCity("Vijay Nagar");
//    	student.setId(106);
//    	int update = studentdao.update(student);
//    	System.out.println(update);
//    	student.setId(103);
//    	int delete = studentdao.delete(student.getId());
//    	System.out.println(delete);
//    	student.setId(101);
//    	Student student_select = studentdao.getStudent(student.getId());
//    	System.out.println(student_select);
    	List<Student> students = studentdao.getStudent();
    	for( Student s : students) {
    		System.out.println(s);
    	}
    	
    }
}
  