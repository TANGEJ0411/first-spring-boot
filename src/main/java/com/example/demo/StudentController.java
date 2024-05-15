package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}

	@GetMapping("/getStudent/{id}")
	public Student queryStudent(@PathVariable int id) {

		return studentService.getById(id);
	}

	@GetMapping("/getStudents")
	public List<Student> queryStudent() {

		return studentService.queryStudent();
	}

}
