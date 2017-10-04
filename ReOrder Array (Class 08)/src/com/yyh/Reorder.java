package com.yyh;

import java.util.Arrays;

/*
 * Given an array of elements, reorder it as follow:
 * 	{ N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 * 	{ N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 * Try to do it in place.
 */

public class Reorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(reorder(new int[]{1, 2, 3, 4, 5})));
	}

	public static int[] reorder(int[] array) {
	    // Assumptions: array is not null
		if (array.length % 2 == 0){
			reorder(array, 0, array.length - 1);
		} else {
			// if array has odd number of elements, we ignore the last one
			// when do the reordering
			reorder(array, 0, array.length - 2);
		}
		return array;
	}
	
	private static void reorder(int[] array, int left, int right){
		int length = right - left + 1;
		// if the subarray has 2 or 0 elements, we can just return
		// as this should be the base case
		if (length <= 2){
			return;
		}
		// Calculate the important mid points:
		// 0 1 2 3 4 5 6 7
		// lm: 2, m: 4, rm: 6
		// 0 1 2 3 4 5 6 7 8 9
		// lm: 2, m: 5, rm: 7
		int mid = left + length / 2;
		int lmid = left + length / 4;
		int rmid = left + length *3 / 4;
		reverse(array, lmid, mid - 1);
		reverse(array, mid, rmid - 1);
		reverse(array, lmid, rmid -1);
		// half of the left partition's size = lmid - left
		reorder(array, left, left + (lmid - left) * 2 - 1);
		reorder(array, left + (lmid - left) * 2, right);
	}
	
	private static void reverse(int[] array, int left, int right){
		while (left < right){
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}
}
