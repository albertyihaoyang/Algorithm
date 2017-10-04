package com.yyh;

//Given an integer, write a function to determine if it is a power of three.

public class IsPowerOfThreeLoopIteration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsPowerOfThreeLoopIteration my = new IsPowerOfThreeLoopIteration();
		System.out.println(my.isPowerOfThree(3));
	}

	public boolean isPowerOfThree(int n) {
        if (n <= 0){
            return false;
        } else if (n == 1){
            return true;
        }
        while (n > 1) {
            if (n % 3 != 0){
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
