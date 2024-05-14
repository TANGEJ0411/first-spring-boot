package com.example.demo;

import org.springframework.stereotype.Component;

import printer.Printer;

@Component
public class CanonPrinter implements Printer {

	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println("Canon" + message);
	}

}
