package com.yyh;
/*
 * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...

So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...

Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.
 */
public class Solution {
	public int newInteger(int n) {
        int res = 0;
        int dig = 1;
        while (n > 0){
            int cur = n % 9;
            res += dig * cur;
            dig *= 10;
            n /= 9;
        }
        return res;
    }
}
