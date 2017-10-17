package com.yyh;
/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent 
 * houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on 
 * the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Solution {
	public int rob(int[] nums) {
		int max = 0;
		int len = nums.length;
		if (len == 0){
			return 0;
		} else if (len == 1){
			return nums[0];
		} else if (len == 2){
			return (Math.max(nums[0], nums[1]));
		}
		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = nums[1];
		max = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len; i++){
			int curMax = 0;
			for (int j = 0; j < i - 1; j++){
				curMax = Math.max(dp[j], curMax);
			}
			dp[i] = nums[i] + curMax;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
