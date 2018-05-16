package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given a sorted integer array without duplicates, return the summary of its ranges.
public class Solution {
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == end + 1){
                end++;
            } else {
                if (start == end){
                    res.add("" + start);
                } else {
                    res.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end){
            res.add("" + start);
        } else {
            res.add(start + "->" + end);
        }
        return res;
    }
}
