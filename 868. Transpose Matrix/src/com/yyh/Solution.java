package com.yyh;
/*
 * Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 */
public class Solution {
	public int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] res = new int[cols][rows];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
