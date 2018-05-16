package com.yyh;
//Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
public class NumMatrix {
	int[][] dp;
	int[][] cur;
	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
		int m = matrix.length;
		int n = matrix[0].length;

		dp = new int[m + 1][n + 1];
		cur = new int[m][n];
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -dp[i - 1][j - 1] + matrix[i - 1][j - 1];
				cur[i - 1][j - 1] = matrix[i - 1][j - 1];
			}
		}
	}

	public void update(int row, int col, int val) {
		int diff = val - cur[row][col];
		cur[row][col] = val;
		for (int i = row + 1; i < dp.length; i++){
			for (int j = col + 1; j < dp[0].length; j++){
				dp[i][j] += diff;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int iMin = Math.min(row1, row2);
		int iMax = Math.max(row1, row2);

		int jMin = Math.min(col1, col2);
		int jMax = Math.max(col1, col2);

		return dp[iMax + 1][jMax + 1] - dp[iMax + 1][jMin] - dp[iMin][jMax + 1] + dp[iMin][jMin];
	}
}
