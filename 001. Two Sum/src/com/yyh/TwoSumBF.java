package com.yyh;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
import java.util.Arrays;

public class TwoSumBF {

	public static void main(String[] args) {
		TwoSumBF my = new TwoSumBF();
		System.out.println(Arrays.toString(my.twoSum(new int[]{3, 2, 4}, 6)));
	}

	// Time complexity: O(n^2)
	// Space complexity: O(1)
	public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
