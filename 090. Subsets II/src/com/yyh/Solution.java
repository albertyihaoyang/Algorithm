package com.yyh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, 0, cur, set);
        for (List<Integer> list : set){
            res.add(list);
        }
        return res;
    }
    
    public void helper(int[] nums, int index, List<Integer> cur, Set<List<Integer>> set){
        if (index >= nums.length){
            set.add(new ArrayList<>(cur));
            return;
        }
        helper(nums, index + 1, cur, set);
        cur.add(nums[index]);
        helper(nums, index + 1, cur, set);
        cur.remove(cur.size() - 1);
    }
}
