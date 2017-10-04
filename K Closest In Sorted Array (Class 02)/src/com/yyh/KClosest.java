package com.yyh;

import java.util.*;

/*
 * Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, 
 * find the K closest numbers to T in A.
 */
public class KClosest {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int target = 2;
		int k = 3;
		System.out.println(Arrays.toString(kClosest(a,target,k)));
	}
	
	public static int[] kClosest(int[] array,int target,int k){
		int k_idx = 0;
		if (array == null || array.length == 0 || k == 0){
			int[] b = {};
			return b;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1){
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;			
			}
		}
		int[] b = new int [k];
		while (k_idx < k){
			if (left < 0) {
				b[k_idx] = array[right];
				right++;
			} else if (right > array.length - 1) {
				b[k_idx] = array[left];
				left--;
			} else if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
				b[k_idx] = array[left];
				left--;
			} else {
				b[k_idx] = array[right];
				right++;
			}
			k_idx++;			
		}
		return b;
	}
}
