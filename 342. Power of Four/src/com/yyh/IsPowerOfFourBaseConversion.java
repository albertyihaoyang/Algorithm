package com.yyh;

//Given an integer, write a function to determine if it is a power of 4.

public class IsPowerOfFourBaseConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfFourBaseConversion my = new IsPowerOfFourBaseConversion();
		System.out.println(my.isPowerOfFour(1));
	}

	public boolean isPowerOfFour(int n) {
		return Integer.toString(n, 4).matches("^10*$");
    }
}
