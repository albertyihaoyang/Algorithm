package com.yyh;

import java.util.List;

// Given a list of integers representing the lengths of urls, 
// find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).
public class Percentile95 {
	public int percentile95(List<Integer> lengths) {
	    int size = lengths.size();
	    int[] counter = new int[4097];
	    int acc = 0;
	    for (Integer length : lengths){
	      counter[length]++;
	    }
	    for (int i = 1; i <= 4096; i++){
	      acc += counter[i];
	      if (acc >= size * 0.95){
	        return i;
	      }
	    }
	    return 0;
	  }
}
