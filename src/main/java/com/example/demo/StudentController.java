package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
//		Integer id = student.getId();
//		String nameString = student.getName();
//
//		System.out.println(id + nameString);

		// String sqlString = STR."INSERT INTO student(id, name) VALUES (\{id},
		// \{nameString})";

		// String sqlString = String.format("INSERT INTO student(id, name) VALUES (%d,
		// '%s')", id, nameString);
		String sqlString = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";
		System.out.println(sqlString);

		Map<String, Object> map = new HashMap<>();

		map.put("studentId", student.getId());
		map.put("studentName", student.getName());

		namedParameterJdbcTemplate.update(sqlString, map);

		return "執行insert";
	}

	@GetMapping("/getStudent/{id}")
	public Student queryStudent(@PathVariable int id) {
		String sqlString = "SELECT * FROM student WHERE id=:studentId";
		Map<String, Object> map = new HashMap<>();
		map.put("studentId", id);

		Student student = namedParameterJdbcTemplate.queryForObject(sqlString, map, new StudentRowMapper());
		return student;
	}

	@GetMapping("/getStudents")
	public List<Student> queryStudent() {
		String sqlString = "SELECT * FROM student";
		List<Student> studentList = namedParameterJdbcTemplate.query(sqlString, new StudentRowMapper());
		return studentList;
	}

	@PostMapping("/people")
	public String create(@RequestBody Student student) {
		return "Create";
	}

}
