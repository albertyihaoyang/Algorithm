package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindKMostRepeatingElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int n: nums){
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int key : map.keySet()){
			int freq = map.get(key);
			if (buckets[freq] == null){
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int pos = buckets.length - 1; pos >= 0 && res.size() < k; pos--){
			if (buckets[pos] != null){
				res.addAll(buckets[pos]);
			}
		}
		return res;
	}
}
