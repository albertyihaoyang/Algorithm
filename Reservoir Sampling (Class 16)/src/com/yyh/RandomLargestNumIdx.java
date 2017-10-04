package com.yyh;

public class RandomLargestNumIdx {
	private int maxCount;
	private Integer maxIdx;
	private int max;
	
	public RandomLargestNumIdx() {
		this.maxCount = 0;
	    this.maxIdx = 0;
	    this.max = Integer.MIN_VALUE;
	}
	  
	public void read(int value, int idx) {
		if (value < max){
			return;
		} else if (value == max){
			maxCount++;
			int prob = (int)(Math.random() * maxCount);
			if (prob == 0){
				maxIdx = idx;
			}
		} else {
			max = value;
			maxCount = 1;
			maxIdx = idx;
		}
	    
	}
	  
	public Integer sample() {
	    return maxIdx;
	}
}
