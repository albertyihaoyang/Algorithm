package com.yyh;
/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class Solution {
	public int[] productExceptSelf(int[] nums) {
        int pro = 1;
        int count = 0;
        for (int num : nums){
            if (num != 0){
                pro *= num;
            } else {
                count++;
            }
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (count == 0){
                output[i] = pro / nums[i];
            } else if (count == 1){
                if (nums[i] == 0){
                    output[i] = pro;
                } else {
                    output[i] = 0;
                }
            } else {
                output[i] = 0;
            }
        }
        return output;
    }
}
