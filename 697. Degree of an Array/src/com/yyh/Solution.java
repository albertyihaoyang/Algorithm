package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a non-empty array of non-negative integers nums, 
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */
public class Solution {
	public int findShortestSubArray(int[] nums) {
		if (nums.length < 2){
			return nums.length;
		}
		int maxDegree = 0;
		int res = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			List<Integer> cur = map.get(nums[i]);
			if (cur == null){
				cur = new ArrayList<>();
				cur.add(i);
				map.put(nums[i], cur);
			} else {
				cur.add(i);
				if (cur.size() > maxDegree){
					maxDegree = cur.size();
					res = cur.get(cur.size() - 1) - cur.get(0) + 1;
				} else if (cur.size() == maxDegree){
					res = Math.min(res, cur.get(cur.size() - 1) - cur.get(0) + 1);
				}
			}
		}
		return res == 0? 1 : res;
	}
}
