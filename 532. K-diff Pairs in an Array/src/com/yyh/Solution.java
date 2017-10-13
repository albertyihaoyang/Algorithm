package com.yyh;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
// Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{1, 3, 1, 5, 4};
		System.out.println(my.findPairs(nums, 0));
	}

	public int findPairs(int[] nums, int k) {
		if (nums == null || nums.length < 2 || k < 0){
			return 0;
		}
		int res = 0;
		Map<Integer, Integer> ins = new HashMap<>();
		for (int num : nums){
			int val = ins.getOrDefault(num, 0);
			if (val == 0){
				ins.put(num, 1);
			} else {
				ins.put(num, val + 1);
			}
		}
		for (Integer in : ins.keySet()){
			if (k == 0){
				if (ins.get(in) > 1){
					res++;
				}
			} else {
				if (ins.containsKey(in + k)){
					res++;
				}
			}
		}
		return res;
	}
}
