package com.yyh;
/*
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
public class Solution {
	public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length; int col = matrix[0].length;
        for (int i = 0; i < col; i++){
            int cur = matrix[0][i];
            for (int j = 0; i + j < col && j < row;j++){
                if (matrix[j][i + j] != cur){
                    return false;
                }
            }
        }
        for (int i = 0; i < row; i++){
            int cur = matrix[i][0];
            for (int j = 0; i + j < row && j < col;j++){
                if (matrix[i + j][j] != cur){
                    return false;
                }
            }
        }
        return true;
    }
}
