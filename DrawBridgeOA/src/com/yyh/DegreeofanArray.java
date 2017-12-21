package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeofanArray {
	public int findShortestSubArray(int[] nums) {
		if (nums.length < 2){
			return nums.length;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		int res = 0;
		int maxDegree = 0;
		for (int i = 0; i < nums.length; i++){
			List<Integer> list = map.get(nums[i]);
			if (list == null){
				list = new ArrayList<>();
				list.add(i);
				map.put(nums[i], list);
				maxDegree = Math.max(maxDegree, 1);
			} else {
				list.add(i);
				if (list.size() > maxDegree){
					maxDegree = list.size();
					res = list.get(list.size() - 1) - list.get(0) + 1;
				} else if (list.size() == maxDegree){
					res = Math.min(res, list.get(list.size() - 1) - list.get(0) + 1);
				}
			}
		}
		return res == 0 ? 1: res;
	}
}
