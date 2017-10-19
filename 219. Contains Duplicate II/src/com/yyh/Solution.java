package com.yyh;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
// such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            Integer cur = map.get(nums[i]);
            if (cur != null) {
                if (i - cur <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
