package com.yyh;

public class MaxProfit {

	public static void main(String[] args) {
		MaxProfit my = new MaxProfit();
		System.out.println(my.maxProfit(new int[]{2, 1, 2, 0, 1}));
	}

	public int maxProfit(int[] prices) {
		int total = 0;
	    for (int i = 0; i < prices.length-1; i++) {
	        if (prices[i + 1]>prices[i]){
	        	total += prices[i + 1] - prices[i];
	        }
	    }
	    return total;
    }
}
