package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.
public class AllPairs {
	// Method 1: sort the array first and use two pointers
	public List<List<Integer>> allPairs(int[] array, int target) {
		// Assumptions: array is not null, array.length >= 2
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;
		while (left < right){
			// ignore all the consecutive duplicate values when we want to determine the smaller element of the pair.
			if (left > 0 && array[left] == array[left - 1]){
				left++;
				continue;
			}
			int cur = array[left] + array[right];
			if (cur == target){
				result.add(Arrays.asList(array[left], array[right]));
				left++;
				right--;
			} else if (cur < target){
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}
