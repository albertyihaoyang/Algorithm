package com.yyh;

// Given an integer, write a function to determine if it is a power of two.

public class IsPowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfTwo my = new IsPowerOfTwo();
		System.out.println(my.isPowerOfTwo(-16));
	}

	public boolean isPowerOfTwo(int n) {
        int ones = 0;
        while (n != 0 && n > 0){
            ones += n & 1;
            n >>= 1;
        }
        return ones == 1;
    }
}
