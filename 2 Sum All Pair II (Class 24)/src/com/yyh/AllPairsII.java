package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPairsII {
	// Method 2: use HashSet
	public List<List<Integer>> allPairsII(int[] array, int target){
		// Assumptions: array is not null, array.length >= 2
		List<List<Integer>> result = new ArrayList<>();
		// Record the number of existence of the values
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : array){
			// Two cases when we need to make the pair a solution:
			// 1. if 2*x == target, and we need to make sure there is no duplicates
			// 2. if x+y == target, and this is the first time both x and y are present, so we can make sure there is no duplicates
			Integer count = map.get(num);
			if (num * 2 == target && count != null && count == 1){
				result.add(Arrays.asList(num, num));
			} else if (map.containsKey(target - num) && count == null){
				result.add(Arrays.asList(target - num, num));
			}
			if (count == null){
				map.put(num, 1);
			} else {
				map.put(num, count + 1);
			}
		}
		return result;
	}
}
