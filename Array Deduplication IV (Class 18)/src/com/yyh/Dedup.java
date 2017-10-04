package com.yyh;

import java.util.Arrays;

/*
 * Given an unsorted integer array, remove adjacent duplicate elements repeatedly, from left to right. 
 * 	For each group of elements with the same value do not keep any of them.
 * Do this in-place, using the left side of the original array. Return the array after deduplication.
 */
public class Dedup {
	public int[] dedup(int[] array) {
		int end = -1;
		for (int i = 0; i < array.length; i++){
			if (end == -1 || array[end] != array[i]){
				array[++end] = array[i];
			} else {
				while (i + 1 < array.length && array[i + 1] == array[end]){
					i++;
				}
				end--;
			}
		}
		return Arrays.copyOf(array, end + 1);
	}
}
