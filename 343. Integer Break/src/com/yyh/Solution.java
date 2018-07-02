package com.yyh;
// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
public class Solution {
	public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) return 1;
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
            }
        }
        return dp[n];
    }
}
