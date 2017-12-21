package com.yyh;
/*
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, 
 * and you can either start from the step with index 0, or the step with index 1.
 */
public class Solution {
	public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        if (cost.length < 2){
            return 0;
        }
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
