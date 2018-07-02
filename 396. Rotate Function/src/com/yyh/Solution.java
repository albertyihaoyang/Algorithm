package com.yyh;
/*
 * Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).
 */
public class Solution {
	public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0, val = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
            val += A[i] * i;
        }
        
        int max = val;
        for (int i = 1; i < A.length; i++){
            val = val - sum + A[i - 1] * A.length;
            max = Math.max(val, max);
        }
        
        return max;
    }
}
