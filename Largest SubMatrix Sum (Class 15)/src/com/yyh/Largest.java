package com.yyh;
// Given a matrix that contains integers, find the submatrix with the largest sum.
// Return the sum of the submatrix.
public class Largest {

	public static void main(String[] args) {
		Largest my = new Largest();
		int[][] matrix = new int[][]{{1, -2, -1, 4},{1, -1,  1, 1},{0, -1, -1, 1},{0,  0,  1, 1}};
		System.out.println(my.largest(matrix));
	}
	
	public int largest(int[][] matrix) {
	   if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
		   return 0;
	   }
	   int row = matrix.length;
	   int col = matrix[0].length;
	   // Prefix sum for each column
	   int[][] prefixSum = new int[row][col];
	   for (int i = 0; i < col; i++){
		   prefixSum[0][i] = matrix[0][i];
		   for (int j = 1; j < row; j++){
			   prefixSum[j][i] = matrix[j][i] + prefixSum[j - 1][i];
		   }
	   }
	   // Determine upper and lower bound
	   int global = Integer.MIN_VALUE;
	   for (int upR = 0; upR < row; upR++){
		   for (int downR = upR; downR < row; downR++){
			   // For each pair, sum up to one row and use 1-D max subarray sum
			   int[] S = new int[col];
			   for (int i = 0; i < col; i++){
				   S[i] = prefixSum[downR][i] - prefixSum[upR][i] + matrix[upR][i];
			   }
			   global = Math.max(global, max1D(S));
		   }
	   }
	   return global;
	}
	
	private int max1D(int[] S){
		int global = S[0];
		int cur = S[0];
		for (int i = 1; i < S.length; i++){
			cur = cur >= 0 ? cur + S[i] : S[i];
			global = Math.max(global, cur);
		}
		return global;
	}
}
