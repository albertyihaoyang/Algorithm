package com.yyh;
import java.util.*;
public class Candidates {

	public static void main(String[] args) {
		Candidates my = new Candidates();
		int[] candidates = new int[]{1, 2, 0, 3, 0, 0, 3};
		System.out.println(my.kGroup(candidates, 1));
	}

	// Just Brute force to find ascending sequence
	public int threeGroup(int[] candidates){
		if (candidates.length <= 2){
			return 0;
		}
		int[] acc = new int[candidates.length];
		acc[0] = candidates[0];
		for (int i = 1; i < acc.length; i++){
			acc[i] = acc[i - 1] + candidates[i]; 
		}
		int total = acc[acc.length - 1];
		if (total % 3 != 0){
			return 0;
		}
		int count = 0;
		for (int i = 0; i < acc.length - 2; i++){
			if (acc[i] == total / 3){
				for (int j = i + 1; j < acc.length - 1; j++){
					if (acc[j] == total / 3 * 2){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	// Time complexity: O(n) by using HashMap & DP
	// Space complexity: O(n)
	public int kGroup(int[] candidates, int k){
		if (candidates.length < k || k < 1){
			return 0;
		}
		int[] acc = new int[candidates.length];
		acc[0] = candidates[0];
		for (int i = 1; i < acc.length; i++){
			acc[i] = acc[i - 1] + candidates[i]; 
		}
		int total = acc[acc.length - 1];
		if (total % k != 0){
			return 0;
		}
		// Recursive method
//		int[] resultR = new int[]{0};
//		findSeq(acc, 0, 1, total, k, resultR);
//		return resultR[0];
		// DP
		return findSeq(acc, total, k);
	}
	
	// To find a strictly ascending sequence varying by total/k in the accumulated dp array
	// using recursion
	// Time complexity: O(n^k)
	private void findSeq(int[] acc, int idx, int currentK, int total, int k, int[] result){
		if (idx == acc.length){
			if (currentK == k + 1){
				result[0]++;
				return;
			}
			return;
		}
		while (idx < acc.length){
			if (acc[idx] == total / k * currentK){
				findSeq(acc, idx + 1, currentK + 1, total, k, result);
			}
			idx++;
		}
	}
	
	// DP method with map
	private int findSeq(int[] acc, int total, int k){
		int each = total / k; 
		if (total != 0){
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < acc.length; i++){
				// Base case
				if (acc[i] == each){
					map.put(1, map.getOrDefault(1, 0) + 1);				
				} else if (acc[i] % each == 0){
					int cur = acc[i] / each;
					map.put(cur, map.getOrDefault(cur - 1, 0) + map.getOrDefault(cur, 0));
				}
			}
			return map.getOrDefault(k, 0);
		} else {
			int count = 0;
			for (int i = 0; i < acc.length; i++){
				if (acc[i] == each){
					count++;
				}
			}
			int c = 1;
			for (int i = 1; i <= k; i++){
				c = c * (count - i + 1) / i;
			}
			return c;
		}
	}
}
