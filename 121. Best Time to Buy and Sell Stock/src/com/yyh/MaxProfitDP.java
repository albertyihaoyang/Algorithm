package com.yyh;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
public class MaxProfitDP {

	public static void main(String[] args) {
		MaxProfitDP my = new MaxProfitDP();
		System.out.println(my.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}

	public int maxProfit(int[] prices) {
        if (prices.length <= 1){
        	return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
        	minPrice = Math.min(minPrice, prices[i]);
        	maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
