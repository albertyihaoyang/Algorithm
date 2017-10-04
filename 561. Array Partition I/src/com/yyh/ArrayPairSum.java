package com.yyh;


/*
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), 
 * (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */
public class ArrayPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 4, 2, 3};
		System.out.println(arrayPairSum(arr));
	}

	public static int arrayPairSum(int[] nums) {
        int sum = 0;
        int[] newNums = mergeSort(nums);
        for (int i = 0; i < nums.length / 2; i++){
        	sum += newNums[2*i];
        }
        return sum;
    }
	
	public static int[] mergeSort(int[] arr){
		if (arr == null || arr.length <= 1){
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];
		for (int i = 0; i < mid; i++){
			left[i] = arr[i];
		}
		for (int i = mid; i < arr.length; i++){
			right[i - mid] = arr[i];
			
		}
		return merge(mergeSort(left), mergeSort(right));
	}
	
	public static int[] merge(int[] a1, int[] a2){
		int newLen = a1.length + a2.length;
		int[] newArr = new int[newLen];
		int i = 0;
		int j = 0;
		while (i + j < newLen){
			if (i == a1.length){
				newArr[i + j] = a2[j];
				j++;
			} else if (j == a2.length){
				newArr[i + j] = a1[i];
				i++;
			} else if (a1[i] < a2[j]) {
				newArr[i + j] = a1[i];
				i++;
			} else {
				newArr[i + j] = a2[j];
				j++;
			}
		}
		return newArr;
	}
}
