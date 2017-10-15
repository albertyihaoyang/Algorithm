package com.yyh;

import java.util.Arrays;
import java.util.List;

/*
 * Given m arrays, and each array is sorted in ascending order. 
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
 * We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 */

public class Solution {
	static class Pair implements Comparable<Pair>{
		int i;
		int array;
		public Pair(int i, int array){
			this.i = i;
			this.array = array;
		}
		@Override
		public int compareTo(Pair another){
			if (this.i == another.i){
				return 0;
			}
			return this.i < another.i ? -1 : 1;
		}
	}
	
	public int maxDistance(List<List<Integer>> arrays) {
		Pair[] small = new Pair[arrays.size()];
		Pair[] large = new Pair[arrays.size()];
		for (int i = 0; i < arrays.size(); i++){
			List<Integer> cur = arrays.get(i);
			small[i] = new Pair(cur.get(0), i);
			large[i] = new Pair(cur.get(cur.size() - 1), i);
		}
		Arrays.sort(small);
		Arrays.sort(large);
		int i = 0;
		int j = large.length - 1;
		while (i < j){
			if (small[i].array != large[j].array){
				return large[j].i - small[i].i;
			} else {
				return Math.max(large[j - 1].i - small[i].i, large[j].i - small[i + 1].i);
			}
		}
		return 0;
	}
}
