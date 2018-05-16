package com.yyh;
/*
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. 
 * For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 */
public class Solution {
	public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++){
            if (isPrime(countBit(i))){
                res++;
            }
        }
        return res;
    }
    
    private int countBit(int n){
        int res = 0;
        while (n > 0){
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
    
    private boolean isPrime(int n){
        if (n <= 1){
            return false;
        }
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
