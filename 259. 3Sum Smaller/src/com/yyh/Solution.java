package com.yyh;

import java.util.Arrays;

// Given an array of n integers nums and a target, find the number of index triplets i, j, k 
// with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[] nums = new int[]{-2, 0, 1, 3};
		System.out.println(my.threeSumSmaller(nums, 2));
	}
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++){
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k){
				if (nums[i] + nums[j] + nums[k] < target){
					res += k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}
}
