package com.yyh;
/*
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 */
public class Solution {
	public int uniquePathsWithObstacles(int[][] ob) {
		if (ob.length == 0 || ob[0].length == 0){
			return 0;
		}
		int row = ob.length;
		int col = ob[0].length;
		int[][] dp = new int[row][col];
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				if (ob[i][j] == 1){
					dp[i][j] = 0;
				} else if (i == 0 && j == 0){
					dp[i][j] = 1;
				} else if (i == 0){
					dp[i][j] = dp[i][j - 1];
				} else if (j == 0){
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}
		return dp[row - 1][col - 1];
	}
}
