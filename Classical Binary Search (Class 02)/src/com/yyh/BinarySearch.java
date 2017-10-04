package com.yyh;

/*
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index i such that A[i] == T or return -1 if there is no such index.
 */
public class BinarySearch {
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int target = 5;
		System.out.println(binarySearch(a,target));
	}
	
	public static int binarySearch(int[] array, int target ){
		if (array == null || array.length == 0){
			return -1;
		}
		int start = 0, end = array.length - 1;
		while (start <= end){
			int mid = start + (end - start)/2;
			if (array[mid] == target){
				return mid;
			} else if (array[mid] > target){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
