package com.yyh;

import java.util.Arrays;

/*
 * Use the least number of comparisons to get the largest and smallest number in the given integer array. 
 * Return the largest number and the smallest number.
 */
public class LargestAndSmallest {

	public static void main(String[] args) {
		int[] arr = new int[]{2, 1, 5, 4, 3};
		System.out.println(Arrays.toString(largestAndSmallest(arr)));
	}

	public static int[] largestAndSmallest(int[] array) {
		if (array.length == 1){
			return new int[]{array[0], array[0]};
		}
		int len = array.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		if (len % 2 == 0){
			int[] large = new int[len / 2];
			int[] small = new int[len / 2];
			for (int i = 0; i < len / 2; i++){
				large[i] = Math.max(array[i * 2], array[i * 2 + 1]);
				small[i] = Math.min(array[i * 2], array[i * 2 + 1]);
			}
			for (int i = 0; i < len / 2; i++){
				max = Math.max(max, large[i]);
			}
			for (int i = 0; i < len / 2; i++){
				min = Math.min(min, small[i]);
			}
		} else {
			int[] large = new int[(len + 1) / 2];
			int[] small = new int[(len + 1) / 2];
			for (int i = 0; i < len / 2; i++){
				large[i] = Math.max(array[i * 2], array[i * 2 + 1]);
				small[i] = Math.min(array[i * 2], array[i * 2 + 1]);
			}
			large[len / 2] = array[len - 1];
			small[len / 2] = array[len - 1];
			for (int i = 0; i < (len + 1) / 2; i++){
				max = Math.max(max, large[i]);
			}
			for (int i = 0; i < (len + 1) / 2; i++){
				min = Math.min(min, small[i]);
			}
		}
		return new int[]{max, min};
	}
}
