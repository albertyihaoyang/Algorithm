package com.yyh;

// Determine the number of bits that are different for two given integers

public class DiffBits {

	public static void main(String[] args) {
		DiffBits my = new DiffBits();
		System.out.println(my.diffBits(-1, 0));
	}

	public int diffBits(int a, int b) {
	    int c = a ^ b;
	    int count = 0;
	    for (int i = 0; i < 32; i++){
	      if ((c & 1) == 1){
	        count++;
	      }
	      c >>= 1;
	    }
	    return count;
	 }
}
