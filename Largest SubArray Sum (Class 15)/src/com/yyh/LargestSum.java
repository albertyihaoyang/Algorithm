package com.yyh;
// Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
public class LargestSum {

	public static void main(String[] args) {
		LargestSum my = new LargestSum();
		System.out.println(my.largestSum(new int[]{2, -1, 4, -2, 1}));
	}

	public int largestSum(int[] array) {
	    int[] result = new int[array.length];
	    result[0] = array[0];
	    int max = result[0];
	    for (int i = 1; i < array.length; i++){
	      result[i] = (result[i - 1] >= 0) ? (result[i - 1] + array[i]): array[i];
	      max = Math.max(max, result[i]);
	    }
	    return max;
	  }
}
