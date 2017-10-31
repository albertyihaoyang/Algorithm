package com.yyh;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.
 */
public class Solution {
	public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.length() == 0){
            return 0;
        }
        if (s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++){
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            int cur = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (cur <= 26 && cur > 9){
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
