package com.yyh;
/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, 
 * you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 */
public class Solution {
	int sum;

	public int findTargetSumWays(int[] nums, int S) {
		sum = 0;
		helper(nums, S, 0);
		return sum;
	}

	private void helper(int[] nums, int S, int ind){
		if (ind == nums.length){
			if (S == 0){
				sum++;
			}
			return;
		}
		helper(nums, S - nums[ind], ind + 1);
		helper(nums, S + nums[ind], ind + 1);
	}
}
