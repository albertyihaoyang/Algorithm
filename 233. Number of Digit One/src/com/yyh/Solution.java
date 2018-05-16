package com.yyh;
//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
public class Solution {
	public int countDigitOne(int n) {
        int ones = 0, m = 1, r = 1;
        while (n > 0) {
            ones += (n + 8) / 10 * m + (n % 10 == 1 ? r : 0);
            r += n % 10 * m;
            m *= 10;
            n /= 10;
        }
        return ones;
    }
}
