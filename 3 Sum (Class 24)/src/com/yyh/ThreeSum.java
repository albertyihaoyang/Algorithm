package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Determine if there exists three elements in a given array that sum to the given target number. 
// Return all the triple of values that sums to target.
public class ThreeSum {
	public List<List<Integer>> allTriples(int[] array, int target) {
		// Assumptions: array is not null, array.length >= 3
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++){
			// Our goal is to find i < j < k, such that array[i]+array[j]+array[k]==target,
			// To make sure there is no duplicate tuple, we ignore all the duplicate possible i.
			// e.g. if we have 2,2,2, only the first 2 will be selected as i.
			if (i > 0 && array[i] == array[i - 1]){
				continue;
			}
			int left = i + 1;
			int right = array.length - 1;
			while (left < right){
				// ignore all the consecutive duplicate values when we want to determine the smaller element of the pair.
				int cur = array[left] + array[right];
				if (cur + array[i] == target){
					result.add(Arrays.asList(array[i], array[left], array[right]));
					left++;
					// ignore all possible duplicate j as well.
					while (left < right && array[left] == array[left - 1]){
						left++;
					}
				} else if (cur + array[i] < target){
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
