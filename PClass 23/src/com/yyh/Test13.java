package com.yyh;

import java.util.Scanner;

public class Test13 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type: ");
		while (true){
			String line = scanner.nextLine();
			if (line.toLowerCase().equals("exit")){
				break;
			}
			System.out.println("Input text: " + line);
		}
	}
}
