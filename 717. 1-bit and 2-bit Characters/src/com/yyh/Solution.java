package com.yyh;
// We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

// Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
public class Solution {
	public boolean isOneBitCharacter(int[] bits) {
        boolean[] dp = new boolean[bits.length];
        if (bits.length == 0){
            return false;
        }
        if (bits.length == 1){
            if (bits[0] == 0) return true;
            else return false;
        }
        dp[0] = true;
        if (bits[0] == 0) {
            dp[1] = true;
        }
        for (int i = 2; i < bits.length; i++){
            if ((bits[i - 1] == 0 && dp[i - 1] == true) || (dp[i - 2] == true && bits[i - 2] == 1)){
                dp[i] = true;
            }
        }
        return dp[dp.length - 1];
    }
}
