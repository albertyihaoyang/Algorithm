package com.yyh;
/*
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 */
public class Solution {
	public void rotate(int[][] matrix) {
        helper(matrix, 0);
    }
    
    private void helper(int[][] matrix, int os){
        int row = matrix.length;
        if (os > row / 2 - 1){
            return;
        }
        for (int i = 0; i < row - 2 * os - 1; i++){
            int tmp = matrix[os][os + i];
            matrix[os][os + i] = matrix[row - os - 1 - i][os];
            matrix[row - os - 1 - i][os] = matrix[row - 1 - os][row - os - 1 - i];
            matrix[row - 1 - os][row - os - 1 - i] = matrix[os + i][row - 1 - os];
            matrix[os + i][row - 1 - os] = tmp;
        }
        helper(matrix, os + 1);
    }
}
