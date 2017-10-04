package com.yyh;
/*
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts 
 * with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? 
 * m is determined by you and must be greater than 0 (at least one cut must be made). Return the max 
 * product you can have.
 */
public class MaxProduct1 {

	public static void main(String[] args) {
		MaxProduct1 my = new MaxProduct1();
		System.out.println(my.maxProduct(12));
		System.out.println(my.maxProduct(1000));
	}

	public int maxProduct(int length) {
	    int[] arr = new int[length + 1];
	    arr[0] = 0;
	    arr[1] = 1;
	    for (int i = 2; i <= length; i++){
	    	int max = 0;
	    	for (int j = 1; j <= i / 2; j++){
	    		int cur = Math.max(arr[j], j) * Math.max(arr[i - j], i - j);
	    		max = Math.max(max, cur);
	    	}
	    	arr[i] = max;
	    }
	    return arr[length];
	 }
}
