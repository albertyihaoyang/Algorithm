package com.yyh;

import java.util.Arrays;

public class RainbowSort {
	public static void main(String[] args){
		int [] arr = new int[]{4, 2, 1, 5, 6, 3};
		System.out.println(Arrays.toString(rainbowSort(arr)));
		System.out.println(rainbowSort(null));
	}
	public static int[] rainbowSort(int[] array) {
	    myRainbowSort(array);
	    return array;
	  }
	
	public static void myRainbowSort(int [] array){
		if (array == null || array.length < 2) {
	    	return;
	    } else {
	    	int i = 0, j = 0, k = array.length-1;
	    	while (j<=k){
	    		if (array[j] == -1){
	    			array[j] = array[i];
	    			array[i]=-1;
	    			i++;
	    			j++;	
	    		} else if (array[j] == 0){
	    			j++;
	    		} else {
	    			array[j] = array[k];
	    			array[k] = 1;
	    			k--;
	    		}
	    	}
	    }
	}
}
