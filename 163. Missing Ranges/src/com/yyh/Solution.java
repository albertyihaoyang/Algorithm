package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0){
            if (lower == upper){
                res.add("" + lower);
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        if (nums[0] > lower){
            if (nums[0] == lower + 1){
                res.add("" + lower);
            } else {
                res.add(lower + "->" + (nums[0] - 1));
            }
        }
        for (int i = 0; i < len - 1; i++){
            if (nums[i + 1] <= nums[i] + 1 || nums[i] == Integer.MAX_VALUE){
                continue;
            } else if (nums[i + 1] == nums[i] + 2){
                res.add("" + (nums[i] + 1));
            } else {
                res.add((nums[i] + 1) + "->" + (nums[i + 1] - 1));
            }
        }
        if (nums[len - 1] < upper){
            if (nums[len - 1] == upper - 1){
                res.add("" + upper);
            } else {
                res.add((nums[len - 1] + 1) + "->" + upper);
            }
        }
        return res;
    }
}
