package com.yyh;
/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * 	the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {

	public static void main(String[] args) {
		MaxSubArray my = new MaxSubArray();
		System.out.println(my.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

	public int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
        	result[i] = nums[i] + (result[i - 1] > 0 ? result[i - 1] : 0);
        	max = Math.max(max, result[i]);
        }
        return max;
    }
}
