package com.yyh;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
import java.util.*;

public class TwoSumHashMap {

	public static void main(String[] args) {
		TwoSumHashMap my = new TwoSumHashMap();
		System.out.println(Arrays.toString(my.twoSum(new int[]{3, 2, 4}, 6)));
	}

	// Time complexity : O(n)
	// Space complexity: O(n)
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
        	if (map.containsKey(target - nums[i])){
        		return new int[]{map.get(target - nums[i]), i};
        	}
        	map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
