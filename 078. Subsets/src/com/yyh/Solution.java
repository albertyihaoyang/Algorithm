package com.yyh;

import java.util.ArrayList;
import java.util.List;

// Given a set of distinct integers, nums, return all possible subsets.
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null){
			return res;
		}
		List<Integer> sol = new ArrayList<>();
		if (nums.length == 0){
			res.add(sol);
			return res;
		}
		helper(res, sol, nums, 0);
		return res;
	}
	
	private void helper(List<List<Integer>> res, List<Integer> sol, int[] nums, int index){
		if (index == nums.length){
			res.add(new ArrayList<>(sol));
			return;
		}
		sol.add(nums[index]);
		helper(res, sol, nums, index + 1);
		sol.remove(sol.size() - 1);
		helper(res, sol, nums, index + 1);
	}
}
