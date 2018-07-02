package com.yyh;

public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
        int len = A.length - 1;
        if (len < 2) return 0;
        int[] diff = new int[len];
        for (int i = 1; i < len + 1; i++){
            diff[i - 1] = A[i] - A[i - 1];
        }
        int res = 0;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++){
            if (diff[i] != diff[i - 1]){
                dp[i] = 0;
                res += dp[i - 1] * (dp[i - 1] + 1) / 2;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        res += dp[len - 1] * (dp[len - 1] + 1) / 2;
        return res;
    }
}
