package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Student getById(int studentId) {
		String sqlString = "SELECT * FROM student WHERE id=:studentId";
		Map<String, Object> map = new HashMap<>();
		map.put("studentId", studentId);

		List<Student> list = namedParameterJdbcTemplate.query(sqlString, map, new StudentRowMapper());

		if (list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
	public String insertStudent(Student student) {
		String sqlString = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

		Map<String, Object> map = new HashMap<>();

		map.put("studentId", student.getId());
		map.put("studentName", student.getName());

		namedParameterJdbcTemplate.update(sqlString, map);

		return "執行insert";
	}
	
	public List<Student> queryStudent(){
		String sqlString = "SELECT * FROM student";
		List<Student> studentList = namedParameterJdbcTemplate.query(sqlString, new StudentRowMapper());
		return studentList;
	}

}
