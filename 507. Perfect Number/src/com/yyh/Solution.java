package com.yyh;
// We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
// Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
public class Solution {
	public boolean checkPerfectNumber(int num) {
        if (num <= 1){
            return false;
        }
        int res = 1;
        int i = 2;
        while (i * i < num){
            if (num % i == 0){
                res += i + num / i;
            }
            i++;
        }
        if (i * i == num){
            res += i;
        }
        return res == num;
    }
}
