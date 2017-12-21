package com.yyh;
// Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0, zero = 0, k = 1;
		for (int l = 0, r = 0; r < nums.length; r++){
			if (nums[r] == 0){
				zero++;
			}
			while (zero > k){
				if (nums[l++] == 0){
					zero--;
				}
			}
			max = Math.max(max, r - l + 1);
		}
		return max;
	}
}
