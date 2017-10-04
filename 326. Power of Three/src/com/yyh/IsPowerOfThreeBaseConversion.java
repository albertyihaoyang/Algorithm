package com.yyh;

//Given an integer, write a function to determine if it is a power of three.

public class IsPowerOfThreeBaseConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfThreeBaseConversion my = new IsPowerOfThreeBaseConversion();
		System.out.println(my.isPowerOfThree(1));
	}

	public boolean isPowerOfThree(int n) {
		return Integer.toString(n, 3).matches("^10*$");
    }
}
