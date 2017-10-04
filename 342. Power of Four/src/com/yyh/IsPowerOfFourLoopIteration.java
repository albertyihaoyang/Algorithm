package com.yyh;

//Given an integer, write a function to determine if it is a power of 4.

public class IsPowerOfFourLoopIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfFourLoopIteration my = new IsPowerOfFourLoopIteration();
		System.out.println(my.isPowerOfFour(3));
	}

	public boolean isPowerOfFour(int n) {
        if (n <= 0){
            return false;
        } else if (n == 1){
            return true;
        }
        while (n > 1) {
            if (n % 4 != 0){
                return false;
            }
            n /= 4;
        }
        return true;
    }
}
