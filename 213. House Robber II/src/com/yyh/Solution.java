package com.yyh;
/*
 * After robbing those houses on that street, the thief has found himself a new place for his thievery 
 * so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Solution {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0){
			return 0;
		} else if (len == 1) return nums[0];
		else if (len == 2) return Math.max(nums[0], nums[1]);
		int max0 = 0;
		int[] dp = new int[len];
		dp[0] = 0;
		dp[1] = nums[1];
		max0 = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len; i++){
			int curMax = 0;
			for (int j = 0; j < i - 1; j++){
				curMax = Math.max(dp[j], curMax);
			}
			dp[i] = nums[i] + curMax;
			max0 = Math.max(max0, dp[i]);
		}
		dp = new int[len];
		dp[0] = nums[0];
		dp[1] = nums[1];
		int max1 = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len - 1; i++){
			int curMax = 0;
			for (int j = 0; j < i - 1; j++){
				curMax = Math.max(dp[j], curMax);
			}
			dp[i] = nums[i] + curMax;
			max0 = Math.max(max0, dp[i]);
		}
		return Math.max(max0, max1);
	}
}
