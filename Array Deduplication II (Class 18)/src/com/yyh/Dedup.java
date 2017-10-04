package com.yyh;
/*
 * Given a sorted integer array, remove duplicate elements. For each group of elements with 
 * the same value keep at most two of them. Do this in-place, using the left side of the original 
 * array and maintain the relative order of the elements of the array. Return the array after deduplication.
 */
public class Dedup {
	public int[] dedup(int[] array) {
		if (array.length <= 2){
			return array;
		}
		int slow = 2;
		int fast = 2;
		while (fast < array.length){
			if (array[fast] != array[slow - 2]){
				array[slow++] = array[fast++];
			} else {
				fast++;
			}
		}
		int[] arr = new int[slow];
		for (int i = 0; i < slow; i++){
			arr[i] = array[i];
		}
		return arr;
	}
}
