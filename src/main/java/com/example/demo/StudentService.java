package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public Student getById(int studentId) {
		return studentDao.getById(studentId);
	}
	
	public String insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}
	
	public List<Student> queryStudent(){
		return studentDao.queryStudent();
	}

}
