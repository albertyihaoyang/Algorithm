package com.yyh;

public class IsPowerOfTwo2 {

	public static void main(String[] args) {
		IsPowerOfTwo2 my = new IsPowerOfTwo2();
		System.out.println(my.isPowerOfTwo(2));
		System.out.println(my.isPowerOfTwo(3));
		System.out.println(my.isPowerOfTwo(16));
		System.out.println(my.isPowerOfTwo(0));
		System.out.println(my.isPowerOfTwo(-1));
	}

	public boolean isPowerOfTwo(int number) {
	    if (number <= 0) {
	      return false;
	    }
	    int count = 0;
	    while (number != 0){
	      if ((number & 1) == 1){
	        count++;
	      }
	      number >>= 1;
	    }
	    return count == 1;
	  }
}
