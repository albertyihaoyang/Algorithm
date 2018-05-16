package com.yyh;
/*
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 */
public class Solution {
	public int dominantIndex(int[] nums) {
        int max = 0;
        int maxL = -1;
        int secMax = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max){
                secMax = max;
                max = nums[i];
                maxL = i;
            } else if (nums[i] > secMax){
                secMax = nums[i];
            }
        }
        return secMax == 0 || (max / secMax >= 2)? maxL: -1;
    }
}
