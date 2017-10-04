package com.yyh;

/*
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index i in A such that A[i] is closest to T.
 */

public class Closest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,3,4};
		int target = 2;
		System.out.println(closest(a,target));
	}
	
	public static int closest(int[] array, int target){
		if (array == null || array.length == 0 ) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while (left < right - 1){
			int mid = left + (right - left) / 2;
			if (array[mid] == target){
				return mid;
			} else if (array[mid] > target){
				right = mid;
			} else {
				left = mid;
			}
		}
		return (Math.abs(array[left] - target) < Math.abs(array[right] - target))? left : right;
	}
}
