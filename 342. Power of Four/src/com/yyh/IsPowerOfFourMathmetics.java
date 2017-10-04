package com.yyh;

//Given an integer, write a function to determine if it is a power of three.

public class IsPowerOfFourMathmetics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfFourMathmetics my = new IsPowerOfFourMathmetics();
		System.out.println(my.isPowerOfFour(4));
	}

	public boolean isPowerOfFour(int n) {
		return n > 0 && 1073741824 % n == 0;
    }
}
