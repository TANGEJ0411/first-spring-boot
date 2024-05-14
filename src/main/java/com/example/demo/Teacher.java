package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import printer.Printer;

@Component
public class Teacher {
	// 本來每一個都需要被instance
//	private Printer hpPrinter = new HpPrinter();
//
//	private Printer canonPrinter = new CanonPrinter();
//
//	public void teach2() {
//		if (hpPrinter != null) {
//			hpPrinter.print("HP");
//		} else if (canonPrinter != null) {
//			canonPrinter.print("CANON");
//		} else {
//			System.out.println("FAILED");
//		}
//	}
	
	// 透過spring boot 使用 IoC 的技術管理要安排哪一個printer，可以簡化成以下
	@Autowired
	@Qualifier("canonPrinter")
	private Printer printer;

	public void teach() {
		printer.print("print it out");
	}
}
