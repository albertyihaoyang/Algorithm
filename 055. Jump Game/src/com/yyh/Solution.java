package com.yyh;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0){
			return false;
		}
		int slow = 0;
		int fast = 0;
		while (slow <= fast && fast < nums.length - 1){
			fast = Math.max(fast, slow + nums[slow]);
			slow++;
		}
		return fast >= nums.length - 1 ? true: false;
	}
}
