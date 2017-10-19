package com.yyh;
/*
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray 
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * Return the modified array after all k operations were executed.
 */
public class Solution {
	public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates){
            for (int i = update[0]; i <= update[1]; i++){
                res[i] += update[2];
            }
        }
        return res;
    }
}
