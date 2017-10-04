package com.yyh;

/*
 * Evaluate a to the power of b, assuming both a and b are integers and b is non-negative. 
 */

public class AToThePowerOfBWithIteration {
	public static void main(String[] args){
		System.out.println(power(2,10));
		System.out.println(power(-2,5));
		System.out.println(power(0,10));
		System.out.println(power(10,0));
	}
	
	public static long power(int a, int b) {
	    // Write your solution here
	    if (b == 0){
	    	return 1;
	    } else if (a == 1 || a == 0){
	    	return a;
	    } else {
	    	long total = 1;
	    	for (int i = 0; i < b; i++){
	    		total *= a;
	    	}
	    	return total;
	    }
	 }
}
