package com.yyh;

import java.util.Arrays;

public class TwoSum {
	// Method 1: sort the array first, then use two pointers
	public boolean existSum(int[] array, int target) {
		// Assumptions: array is not null, and has size >= 2.
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left < right){
			int sum = array[left] + array[right];
			if (sum == target){
				return true;
			} else if (sum < target){
				left++;
			} else {
				right--;
			}
		}
		return false;
	}
}
