package com.ddominguezh.master.v5.exercise;

import java.util.Scanner;

public class Console {

	private Scanner scanner;
	public Console() {
		this.scanner = new Scanner(System.in);
	}
	
	public String readString(String message) {
		System.out.print(message);
		return this.scanner.nextLine();
	}

	public void write(String message) {
		System.out.println(message);
	}

}
