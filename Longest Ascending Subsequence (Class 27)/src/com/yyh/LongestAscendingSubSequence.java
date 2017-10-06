package com.yyh;
// Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
public class LongestAscendingSubSequence {
	// O(n^2)
	public int longest(int[] array) {
		if (array.length == 0){
			return 0;
		}
		int[] longest = new int[array.length];
		int result = 1;
		for (int i = 0; i < array.length; i++){
			longest[i] = 1;
			for (int j = 0; j < i; j++){
				if (array[j] < array[i]){
					longest[i] = Math.max(longest[j] + 1, longest[i]);
				}
			}
			result = Math.max(longest[i], result);
		}
		return result;
	}

	// O(nlgn)
	public int longestII(int[] array){
		if (array.length == 0){
			return 0;
		}
		int[] tbl = new int[array.length + 1];
		int result = 1;
		tbl[1] = array[0];
		for (int i = 1; i < array.length; i++){
			int index = find(tbl, 1, result, array[i]);
			if (index == result){
				tbl[++result] = array[i];
			} else {
				tbl[index + 1] = array[i];
			}
		}
		return result;
	}

	private int find(int[] tbl, int left, int right, int target){
		while (left <= right){
			int mid = left + (right - left) / 2;
			if (tbl[mid] >= target){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
