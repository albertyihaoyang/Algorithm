package com.yyh;

/*
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index of the last occurrence of T in A or return -1 if there is no such index.
 */

public class LastOccurrence {

	public static void main(String[] args) {
		int[] a = {1,2,2,2,4,5,8,13,13};
		int target = 2;
		System.out.println(lastOccurrence(a,target));
	}
	
	public static int lastOccurrence(int[] array, int target ){
		if (array == null || array.length == 0){
			return -1;
		}
		int start = 0, end = array.length - 1;
		while (start < end - 1){
			int mid = start + (end - start)/2;
			if (array[mid] == target){
				start = mid;
			} else if (array[mid] > target){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if (array[end] == target) {
			return end;
		} else if (array[start] == target) {
			return start;
		} else {
			return -1;
		}
	}

}
