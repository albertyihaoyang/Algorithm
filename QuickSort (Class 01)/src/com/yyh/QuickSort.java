package com.yyh;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args){
		int [] arr = new int[]{4, 2, 1, 5, 6, 3};
		System.out.println(Arrays.toString(quickSort(arr)));
		System.out.println(quickSort(null));
	}

	public static int[] quickSort(int[] array){
		myQuickSort(array);
		return array;
	}
	
	public static void myQuickSort(int [] array){
		if (array == null || array.length < 2) {
	    	return;
	    }
	    int pivot = array[array.length-1];
	    int i = 0, j = array.length - 2,temp = 0;
	    while (i<=j){
	    	if (array[i] <= pivot){
	    		i++;
	   		} else {
	   			temp = array[i];
	   			array[i] = array[j];
    			array[j] = temp;
	    		j--;
	    	}
	    }
	    for (int k =  array.length - 1; k > i; k--){
	   		array[k] = array[k-1];
	   	}
	   	array[i] = pivot;
	   	int [] arr1 = new int [i];
		for (int k = 0; k < i; k++){
			arr1[k] = array[k];
		}
		myQuickSort(arr1);
		int [] arr2 = new int [array.length-i-1];
		for (int k = i+1; k < array.length; k++){
			arr2[k-i-1] = array[k];
		}
		myQuickSort(arr2);
		for (int k = 0; k < i; k++){
			array[k] = arr1[k];
		}
		for (int k = i+1; k < array.length; k++){
			array[k] = arr2[k-i-1];
		}
	}
}
