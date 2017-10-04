package com.yyh;

import java.util.Arrays;

/*
 * Given a sorted integer array, remove duplicate elements. For each group of elements with the same value 
 * keep only one of them. Do this in-place, using the left side of the original array and maintain the relative 
 * order of the elements of the array. Return the array after deduplication.
 */
public class Dedup {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 2, 3, 3, 3, 4};
		System.out.println(Arrays.toString(dedup(arr)));
	}

	public static int[] dedup(int[] array) {
		if (array.length == 0){
			return array;
		}
		int slow = 1;
		int fast = 1;
		while (fast < array.length){
			if (array[fast] != array[slow - 1]){
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
