package com.yyh;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
public class MaxProfitBF {

	public static void main(String[] args) {
		MaxProfitBF my = new MaxProfitBF();
		System.out.println(my.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}

	public int maxProfit(int[] prices) {
        if (prices.length <= 1){
        	return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++){
        	for (int j = i; j < prices.length; j++){
        		max = Math.max(max, prices[j] - prices[i]);
        	}
        }
        return max;
    }
}
