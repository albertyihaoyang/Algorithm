package com.yyh;

//Given an integer, write a function to determine if it is a power of three.

public class IsPowerOfThreeMathmetics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfThreeMathmetics my = new IsPowerOfThreeMathmetics();
		System.out.println(my.isPowerOfThree(4));
	}

	public boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
    }
}
