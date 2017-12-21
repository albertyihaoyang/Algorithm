package com.yyh;
// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
public class Solution {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int res = 10;
        int uD = 9;
        int aN = 9;
        while (n-- > 1 && aN > 0){
            uD = uD * aN;
            res += uD;
            aN--;
        }
        return res;
    }
}
