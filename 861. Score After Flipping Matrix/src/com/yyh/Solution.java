package com.yyh;
/*
 * We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.
 */
public class Solution {
	public int matrixScore(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int rows = A.length;
        int cols = A[0].length;
        for (int i = 0; i < rows; i++){
            if (A[i][0] == 0){
                for (int j = 0; j < cols; j++){
                    A[i][j] ^= 1;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < cols; j++){
            int cur = 0;
            for (int i = 0; i < rows; i++){
                cur += A[i][j];
            }
            cur = Math.max(cur, rows - cur);
            res += cur * (1 << (cols - j - 1));
        }
        return res;
    }
}
