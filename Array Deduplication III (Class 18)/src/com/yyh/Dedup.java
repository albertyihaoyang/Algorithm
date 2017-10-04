package com.yyh;
/*
 * Given a sorted integer array, remove duplicate elements. For each group of elements with 
 * the same value do not keep any of them. Do this in-place, using the left side of the original 
 * array and and maintain the relative order of the elements of the array. Return the array after deduplication.
 */
public class Dedup {
	public int[] dedup(int[] array) {
		if (array.length <= 1){
			return array;
		}
		int slow = 0;
		int fast1 = 0;
		int fast2 = 0;
		while (fast2 < array.length){
			if (array[fast2] != array[fast1]){
				if (fast2 == fast1 + 1) {
					array[slow] = array[fast1];
					slow++;
				}
				fast1 = fast2;
			}
			fast2++;
		}
		if (fast1 == array.length - 1){
			array[slow++] = array[fast1];
		}
		int[] arr = new int[slow];
		for (int i = 0; i < slow; i++){
			arr[i] = array[i];
		}
		return arr;
	}
}
