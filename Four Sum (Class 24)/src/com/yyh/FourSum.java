package com.yyh;

import java.util.Arrays;

// Determine if there exists a set of four elements in a given array that sum to the given target number.
public class FourSum {
	// Method 1: sort the array first, O(n^3)
	public boolean exist(int[] array, int target) {
		// Assumptions: array is not null, array.length >= 4
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++){
			for (int j = i + 1; j < array.length - 2; j++){
				int left = j + 1;
				int right = array.length - 1;
				int curTarget = target - array[i] - array[j];
				while (left < right){
					int sum = array[left] + array[right];
					if (sum == curTarget){
						return true;
					} else if (sum < curTarget){
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return false;
	}
}
