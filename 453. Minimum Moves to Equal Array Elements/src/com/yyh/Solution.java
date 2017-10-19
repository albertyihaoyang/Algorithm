package com.yyh;
// Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, 
// where a move is incrementing n - 1 elements by 1.
public class Solution {
	public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = 0;
        for (int num : nums){
            sum += num;
            n++;
            min = Math.min(min, num);
        }
        return sum - min * n;
    }
}
