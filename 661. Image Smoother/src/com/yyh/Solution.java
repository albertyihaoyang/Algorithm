package com.yyh;
// Given a 2D integer matrix M representing the gray scale of an image, 
// you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) 
// of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
public class Solution {
	public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                int cur = M[i][j];
                int count = 1;
                if (i - 1 >= 0){
                    cur += M[i - 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j - 1 >= 0){
                    cur += M[i - 1][j - 1];
                    count++;
                }
                if (j - 1 >= 0){
                    cur += M[i][j - 1];
                    count++;
                }
                if (j - 1 >= 0 && i + 1 < row){
                    cur += M[i + 1][j - 1];
                    count++;
                }
                if (i + 1 < row){
                    cur += M[i + 1][j];
                    count++;
                }
                if (i + 1 < row && j + 1 < col){
                    cur += M[i + 1][j + 1];
                    count++;
                }
                if (j + 1 < col){
                    cur += M[i][j + 1];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < col){
                    cur += M[i - 1][j + 1];
                    count++;
                }
                res[i][j] = cur / count;
            }
        }
        return res;
    }
}
