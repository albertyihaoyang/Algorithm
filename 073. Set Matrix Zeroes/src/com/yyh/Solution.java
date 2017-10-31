package com.yyh;

import java.util.HashSet;
import java.util.Set;

// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class Solution {
	public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> row0 = new HashSet<>();
        Set<Integer> col0 = new HashSet<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    row0.add(i);
                    col0.add(j);
                }
            }
        }
        for (int i : row0){
            for (int j = 0; j < col; j++){
                matrix[i][j] = 0;
            }
        }
        for (int j : col0){
            for (int i = 0; i < row; i++){
                matrix[i][j] = 0;
            }
        }
    }
}
