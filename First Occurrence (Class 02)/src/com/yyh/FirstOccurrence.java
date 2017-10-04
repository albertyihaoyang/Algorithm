package com.yyh;

/*
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index of the first occurrence of T in A or return -1 if there is no such index.
 */

public class FirstOccurrence {

	public static void main(String[] args) {
		int[] a = {4,5,5,5,5};
		int target = 5;
		System.out.println(firstOccurance(a,target));
	}
	
	public static int firstOccurance(int[] array, int target ){
		if (array == null || array.length == 0){
			return -1;
		}
		int start = 0, end = array.length - 1;
		while (start < end){
			int mid = start + (end - start)/2;
			if (array[mid] == target){
				end = mid;
			} else if (array[mid] > target){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (array[start] == target) {
			return start;
		} else {
			return -1;
		}
	}

}
