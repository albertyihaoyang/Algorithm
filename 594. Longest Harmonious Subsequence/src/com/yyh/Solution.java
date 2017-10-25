package com.yyh;

import java.util.HashMap;
import java.util.Map;

// We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
//Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
public class Solution {
	public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int max = 0;
		for (Map.Entry<Integer, Integer> en : map.entrySet()){
			int key = en.getKey();
			int left = map.getOrDefault(key - 1, 0);
			int right = map.getOrDefault(key + 1, 0);
			if (left + right > 0) max = Math.max(max, Math.max(right, left) + map.get(key));
		}
		return max;
	}
}
