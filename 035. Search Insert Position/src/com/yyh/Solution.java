package com.yyh;
// Given a sorted array and a target value, return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
public class Solution {
	public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }
}
