package com.yyh;
// Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.
public class Longest {

	public static void main(String[] args) {
		Longest my = new Longest();
		System.out.println(my.longest(new int[]{0, 1, 0, 1, 1, 1, 0}));
	}

	public int longest(int[] array) {
		if (array.length == 0){
			return 0;
		}
		int max = 0;
		int pre = 0;
		for (int i = 0; i < array.length; i++){
			pre = (array[i] == 1) ? pre + 1: 0;
			max = Math.max(pre, max);
		}
		return max;
	}
}
