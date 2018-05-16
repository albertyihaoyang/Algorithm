package com.yyh;
// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
public class Solution {
	public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++){
            if (i % Math.sqrt(i) == 0){
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= i / 2; j++){
                    min = Math.min(dp[j] + dp[i - j], min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
