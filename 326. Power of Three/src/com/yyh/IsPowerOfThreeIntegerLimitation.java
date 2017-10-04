package com.yyh;

//Given an integer, write a function to determine if it is a power of three.

public class IsPowerOfThreeIntegerLimitation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfThreeIntegerLimitation my = new IsPowerOfThreeIntegerLimitation();
		System.out.println(my.isPowerOfThree(4));
	}

	public boolean isPowerOfThree(int n) {
		return (Math.log(n) / Math.log(3)) % 1 == 0;
    }
}
