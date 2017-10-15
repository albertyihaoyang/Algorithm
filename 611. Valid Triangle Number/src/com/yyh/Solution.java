package com.yyh;

import java.util.Arrays;

// Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array 
// that can make triangles if we take them as side lengths of a triangle.
public class Solution {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int k = nums.length - 1; k >= 2; k--){
			int i = 0;
			int j = k - 1;
			while (i < j){
				if (nums[i] + nums[j] > nums[k]){
					res += j - i;
					j--;
				} else {
					i++;
				}
			}
		}
		return res;
	}
}
