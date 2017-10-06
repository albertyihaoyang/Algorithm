package com.yyh;

import java.util.HashSet;
import java.util.Set;

public class ExistSumII {
	// Method 2: use HashSet to record the previous traversed values
	public boolean existSum(int[] array, int target) {
		// Assumptions: array is not null, and has size >= 2.
		Set<Integer> set = new HashSet<>();
		for (int num : array){
			if (set.contains(target - num)){
				return true;
			}
			set.add(num);
		}
		return false;
	}
}
