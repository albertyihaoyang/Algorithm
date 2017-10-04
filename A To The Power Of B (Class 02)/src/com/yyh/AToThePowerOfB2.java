package com.yyh;

/*
 * Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.
 * 1. type conversion int -> double
 * 2. denominator != 0
 * 3. 0^0 
 */

public class AToThePowerOfB2 {
	public static void main(String[] args){
		System.out.println(powerMain(2,10));
		System.out.println(powerMain(-2,5));
		System.out.println(powerMain(0,10));
		System.out.println(powerMain(10,0));
	}
	
	public static long power(int a, int b) {
	    // Write your solution here
	    if (b == 0){
	    	return 1;
	    } else if (a == 1 || a == 0){
	    	return a;
	    } else if (b == 1) {
	    	return a;
	    } else {
	    	long result = power(a, b / 2);
	    	if (b % 2 == 0){
	    		return result * result;
	    	} else {
	    		return result * result * a;
	    	}
	    	
	    }
	 }
	
	public static double powerMain(int a, int b){
		if (b > 0) {
			return power(a, b);
		} else if (b == 0){
			if (a == 0){
				return 0.0;
			} else {
				return 1;
			}	
		} else {
			return 1 / (double)power(a, -b);
		}
	}
}
