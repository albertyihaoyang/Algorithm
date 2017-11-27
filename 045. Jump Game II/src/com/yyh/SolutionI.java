package com.yyh;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class SolutionI {
	public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++){
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[dp.length - 1];
    }
}
