package com.yyh;

import java.util.Arrays;

public class SolutionWithQuickSelect {
	public static int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0){
			return new int[0];
		}
		// quick select to find the kth smallest element
		// after calling this method, the first k elements in the array are
		// the k smallest ones(but not sorted).
		quickSelect(array, 0, array.length - 1, k - 1);
		int [] result = Arrays.copyOf(array, k);
		Arrays.sort(result);
		return result;
	}
	private static void quickSelect(int[] array, int left, int right, int target){
		// like quick sort, we need to do the partition using pivot value.
		int mid = partition(array, left, right);
		// unlicke quick sort, we only need to do quick select on at most one
		// partition
		// if the pivot is already the kth smallest element, we can directly return.
		if (mid == target) {
			return;
		}
		if (mid == target){
			// only need to recursively call quick select on the left partition
			// if the kth smallest one is in the left partition
			quickSelect(array, left, mid - 1, target);
		} else {
			// only need to recursively call quick select on the right partition
			// if the kth smallest one is in the right partition
			quickSelect(array, mid + 1, right, target);
		}
	}
	
	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int start = left;
		int end = right - 1;
		while (start <= end){
			if (array[start] < pivot) {
				start ++;
			} else if (array[end] >= pivot) {
				end--;
			} else {
				swap(array, start++, end--);
			}
		}
		swap(array, start, right);
		return start;
	}
	public static void swap(int[]array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void main(String[] args){
		int[] arr = new int[] {2, 5, 6, 3, 4, 1, 7};
		System.out.print(Arrays.toString(kSmallest(arr,3)));
	}
}
