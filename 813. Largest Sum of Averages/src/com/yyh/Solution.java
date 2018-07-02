package com.yyh;
// We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?
//Note that our partition must use every number in A, and that scores are not necessarily integers.
public class Solution {
	public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[][] dp = new double[K][len];
        int[] sum = new int[len];
        sum[0] = A[0];
        for (int i = 1; i < len; i++){
            sum[i] = sum[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++){
            dp[0][i] = (sum[i] + 0.0) / (i + 1);
        }
        for (int lvl = 1; lvl < K; lvl++){
            for (int ind = lvl; ind < len; ind++){
                for (int i = lvl - 1; i < ind; i++){
                    dp[lvl][ind] = Math.max(dp[lvl][ind], dp[lvl - 1][i] + (sum[ind] - sum[i] + 0.0) / (ind - i));
                }
            }
        }
        return dp[K - 1][len - 1];
    }
}
