package com.yyh;

import java.util.List;

/*
 * Given m arrays, and each array is sorted in ascending order. 
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
 * We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 */
public class SolutionII {
	public int maxDistance(List<List<Integer>> arrays) {
		int res = Integer.MIN_VALUE;
		List<Integer> cur = arrays.get(0);
		int min = cur.get(0);
		int max = cur.get(cur.size() - 1);
		for (int i = 1; i < arrays.size(); i++){
			List<Integer> array = arrays.get(i);
			int head = array.get(0);
			int tail = array.get(array.size() - 1);
			res = Math.max(Math.max(max - head, tail - min), res);
			max = Math.max(tail, max);
			min = Math.min(head, min);
		}
		return res;
	}
}
