package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import jakarta.annotation.PostConstruct;
import printer.Printer;

@Component
public class HpPrinter implements Printer {

	@Value("${count}")
	private int count;

//	@PostConstruct
//	public void initialize() {
//		count = 5;
//	}

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		count--;
		System.out.println("Hp" + message);
		System.out.println("剩餘次數" + count);
	}

}
