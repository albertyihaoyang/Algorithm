package com.yyh;
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		System.out.println(my.uniquePaths(36, 7));
	}
	
	public int uniquePaths(int m, int n) {
        if (n == 1 || m == 1){
            return 1;
        }
        double res = 1.0;
        for (int i = 1; i <= n - 1; i++){
        	res = res * (m - 1 + i) / i;
        }
        return (int)res;
    }
}
