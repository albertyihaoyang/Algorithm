package com.yyh;

/*
 * Get the Kth number in the Fibonacci Sequence. 
 * (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 */

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(20));
	}

	public static long fibonacci(int K) {
		// Write your solution here
		if (K <= 0) {
			return 0;
		} else if (K == 1) {
			return 1;
		} else {
			long a = 0, b = 1;
			for (int i = 2; i <= K; i++) {
				long temp = a + b;
				a = b;
				b = temp;
			}
			return b;
		}
	}
}
