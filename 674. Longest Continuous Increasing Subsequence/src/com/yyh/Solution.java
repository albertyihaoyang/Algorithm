package com.yyh;
// Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
public class Solution {
	public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int dp = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            dp = (nums[i] > nums[i - 1]) ? dp + 1 : 1;
            max = Math.max(max, dp);    
        }
        return max;
    }
}
