package com.yyh;

public class FibonacciRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(10));
	}

	public static int fibonacci(int a){
		if (a == 1) {
			return 0;
		} else if (a == 2){
			return 1;
		}
		return fibonacci(a-1) + fibonacci(a - 2);
	}
}
