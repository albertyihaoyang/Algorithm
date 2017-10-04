package com.yyh;

public class HammingWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingWeight my = new HammingWeight();
		int n = 2147483647;
		System.out.println(my.hammingWeight(n));
	}

	public int hammingWeight(int n) {
        int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
    }
}
