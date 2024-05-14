package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import printer.Printer;

@RestController
public class HelloController {
	@Autowired
	@Qualifier("hpPrinter")
	private Printer printer;

	@Autowired
	private Teacher teacher;

	@RequestMapping(value = "/")
	public String spring() {
		return "Spring boot!!";
	}

	@RequestMapping(value = "/hello")
	public String hello() {
		printer.print("hello world");
		teacher.teach();

		return "Hello World!!";
	}
	
	@RequestMapping("/product")
	public String product() {
		return "aaba右右左";
	}
	
//	@RequestMapping("/student")
//	public Student user() {
//		Student student = new Student();
//		student.setName("EJ");
//		return student;
//	}
	
	@RequestMapping("/test")
	public Student test(@RequestBody Student student) {
		
		return student;
	}

}
