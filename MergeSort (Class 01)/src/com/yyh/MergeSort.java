package com.yyh;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args){
		int [] arr = new int[]{4, 2, 1, 5, 6, 3};
		System.out.println(Arrays.toString(mergeSort(arr)));
		System.out.println(mergeSort(null));
	}
	
	public static int[] mergeSort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		} else {
			int[] arrl = new int [array.length/2];
			int[] arrr = new int [array.length - array.length/2];
			for (int i = 0; i < array.length/2; i++) {
				arrl[i] = array[i];
			}
			for (int i = array.length/2; i < array.length; i++){
				arrr[i - array.length / 2] = array[i];
			}
			return combine(mergeSort(arrl),mergeSort(arrr));   	
		}
	}
	
	public static int[] combine(int[] arr1, int[] arr2){
		int i = 0, j = 0, idx = 0;
		int[] narr = new int [arr1.length+arr2.length];
		while (idx<narr.length){
			if (i == arr1.length){
				narr[idx] = arr2[j];
				j++;
			}
			else if (j == arr2.length){
				narr[idx] = arr1[i];
				i++;
			}
			else {
				if (arr1[i] < arr2[j]) {
					narr[idx] = arr1[i];
					i++;
				}
				else {
					narr[idx] = arr2[j];
					j++;
				}
			}
			idx++;
		}
		return narr;
	}
}
