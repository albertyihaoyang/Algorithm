package com.yyh;
/*
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 */
public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sl = 0; int f = 0;
        int sum = 0; int res = Integer.MAX_VALUE;
        while (f < nums.length){
            sum += nums[f++];
            while (sum >= s){
                res = Math.min(res, f - sl);
                sum -= nums[sl++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
