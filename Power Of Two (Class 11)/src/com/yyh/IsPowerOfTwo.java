package com.yyh;

public class IsPowerOfTwo {

	public static void main(String[] args) {
		IsPowerOfTwo my = new IsPowerOfTwo();
		System.out.println(my.isPowerOfTwo(2));
		System.out.println(my.isPowerOfTwo(3));
		System.out.println(my.isPowerOfTwo(16));
		System.out.println(my.isPowerOfTwo(0));
		System.out.println(my.isPowerOfTwo(-1));
	}

	public boolean isPowerOfTwo(int number) {
	    return ((number & (number - 1)) == 0 && number > 0);
	}
}
