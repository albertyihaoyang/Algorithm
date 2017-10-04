package com.yyh;

public class Longest {
	public int longest(int[] array) {
	    if (array.length == 0){
	      return 0;
	    } else if (array.length == 1){
	      return 1;
	    }
	    int globalMax = -1;
	    int cur = 1;
	    for (int i = 1; i < array.length; i++){
	      cur = (array[i] > array[i - 1]) ? cur + 1 : 1;
	      globalMax = (cur > globalMax) ? cur : globalMax;
	    }
	    return globalMax;
	  }
}
