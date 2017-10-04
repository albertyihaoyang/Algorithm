package com.yyh;

public class Fibonacci {
	public static void main(String[] args){
		int n = 10;
		int a = 0, b = 1;
		for (int i = 3; i <= n; i++){
			int temp = a + b;
			a = b;
			b = temp;
		}
		System.out.println(b);
	}
}
