package com.yyh;
// Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
// And you need to output the maximum average value.
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++){
            dp[i] = dp[i - 1] + nums[i];
        }
        double max = Integer.MIN_VALUE;
        max = Math.max(max, (dp[k - 1] + 0.0) / k);
        for (int i = k; i < dp.length; i++){
            max = Math.max(max, (dp[i] - dp[i - k]) / (k + 0.0));
        }
        return max;
    }
}
