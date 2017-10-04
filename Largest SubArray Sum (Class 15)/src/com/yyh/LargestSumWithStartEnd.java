package com.yyh;

import java.util.Arrays;

public class LargestSumWithStartEnd {

	public static void main(String[] args) {
		LargestSumWithStartEnd my = new LargestSumWithStartEnd();
		System.out.println(Arrays.toString(my.largestSum(new int[]{-2, 2, -1, 4, -2, 1})));
	}

	public int[] largestSum(int[] array) {
		int start = 0;
	    int sStart = 0;
	    int sEnd = 0;
	    int lastMax = array[0];
	    int max = array[0];
	    for (int i = 1; i < array.length; i++){
	      if (lastMax >= 0){
	    	  lastMax = lastMax + array[i];
	      } else {
	    	  lastMax = array[i];
	    	  start = i;
	      }
	      if (lastMax > max){
	    	  max = lastMax;
	    	  sStart = start;
	    	  sEnd = i;
	      }
	    }
	    return new int[]{max, sStart, sEnd};
	  }
}
