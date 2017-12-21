package com.yyh;
/*
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 */
public class Solution {
	public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num: nums){
            count[num]++;
        }
        int[] dp = new int[count.length + 2];
        for (int i = 10000; i >= 0; i--){
            dp[i] = Math.max(count[i] * i + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
