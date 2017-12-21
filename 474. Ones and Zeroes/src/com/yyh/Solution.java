package com.yyh;
/*
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 */
public class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs){
            int[] count = count(s);
            for (int i = m; i >= count[0]; i--){
                for (int j = n; j >= count[1]; j--){
                    dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] count(String s){
        int[] res = new int[2];
        for (int i = 0; i < s.length(); i++){
            res[s.charAt(i) - '0']++;
        }
        return res;
    }
}
