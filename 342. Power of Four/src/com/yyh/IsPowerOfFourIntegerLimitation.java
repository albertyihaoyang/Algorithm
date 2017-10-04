package com.yyh;

//Given an integer, write a function to determine if it is a power of 4.

public class IsPowerOfFourIntegerLimitation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfFourIntegerLimitation my = new IsPowerOfFourIntegerLimitation();
		System.out.println(my.isPowerOfFour(4));
	}

	public boolean isPowerOfFour(int n) {
		return (Math.log(n) / Math.log(4)) % 1 == 0;
    }
}
