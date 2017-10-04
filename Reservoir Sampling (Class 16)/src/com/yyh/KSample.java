package com.yyh;

public class KSample {
	private int count;
	private Integer[] sample;
	private int k;
	
	public KSample(int k) {
		this.count = 0;
	    this.sample = new Integer[k];
	    this.k = k;
	}
	  
	public void read(int value) {
		count++;
		if (count <= k){
			sample[count - 1] = value;
			return;
		}
		int idx = (int)(Math.random() * (count));
		if (idx < k){
	      sample[idx] = value;
		}
	}
	  
	public Integer[] sample() {
	    return sample;
	}
}
