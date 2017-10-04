package com.yyh;
import java.util.*;

public class SelectionSort {
	public static void main(String[] args){
		int [] arr = new int[]{4, 2, 1, 5, 6, 3};
		System.out.println(Arrays.toString(solve(arr)));
		System.out.println(solve(null));
	}
	
	public static int[] solve(int[] array) {
    if (array == null || array.length == 0) {
    	return array;
    } else {
    	int global = 0;
    	int temp;
    	for (int i = 0; i < array.length; i++) {
    		global = i;
    		for (int j = i+1; j < array.length; j++) {
    			if (array[j] < array[global]) {
    				global = j;
    			}	
    		}
    		temp = array[i];
    		array[i] = array[global];
    		array[global] = temp;
    	}
    }
    return array;
  }
}
