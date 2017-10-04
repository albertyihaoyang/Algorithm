package com.yyh;

import java.util.Arrays;

/*
 * Find the K smallest numbers in an unsorted integer array A. 
 * The returned numbers should be in ascending order.
 */
public class SolutionWithSelectionSort {
	public static int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0){
			return new int[0];
		}
		for (int i = 0; i < k; i++){
			int global = array[i];
			int index = i;
			for (int j = i+1; j < array.length; j++){
				if (array[j] < global) {
					global = array[j];
					index = j;
				}
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	return Arrays.copyOfRange(array, 0, k);
	}
	public static void main(String[] args){
		int[] arr = new int[] {2, 5, 6, 3, 4, 1, 7};
		System.out.print(Arrays.toString(kSmallest(arr,3)));
	}
}
