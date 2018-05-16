package com.yyh;
/*
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class Solution {
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++){
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 0; i < coins.length; i++){
            for (int j = 1; j < amount + 1; j++){
                if (j - coins[i] >= 0)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1? -1: dp[amount];
    }
}
