package com.yyh;
// The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
public class Solution {
	public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] < 0) {
                res[0] = cur;
                continue;
            }
            nums[cur - 1] = -nums[cur - 1];
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res[1] = i + 1;
            }
        }
        return res;
    }
}
