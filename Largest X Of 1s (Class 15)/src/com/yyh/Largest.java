package com.yyh;

public class Largest {

	public static void main(String[] args) {
		Largest my = new Largest();
		int[][] matrix = new int[][]{{0, 0, 0, 0},{1, 1, 1, 1},{0, 1, 1, 1},{1, 0, 1, 1}};
		System.out.println(my.largest(matrix));
	}

	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		
		// Left-top to Right-bottom
		int[][] MLTtoRB = new int[row][col];
		for (int i = 0; i < col; i++){
			MLTtoRB[0][i] = matrix[0][i];
			int j = 1;
			while (i + j < col && j < row){
				if (matrix[j][i + j] == 0){
					MLTtoRB[j][i + j] = 0;
				} else {
					MLTtoRB[j][i + j] = MLTtoRB[j - 1][i + j - 1] + 1;
				}
				j++;
			}
		}
		for (int i = 1; i < row; i++){
			MLTtoRB[i][0] = matrix[i][0];
			int j = 1;
			while (i + j < row && j < col){
				if (matrix[i + j][j] == 0){
					MLTtoRB[i + j][j] = 0;
				} else {
					MLTtoRB[i + j][j] = MLTtoRB[i + j - 1][j - 1] + 1;
				}
				j++;
			}
		}
		
		// Right-bottom to Left-top
		int[][] MRBtoLT = new int[row][col];
		for (int i = 0; i < col; i++){
			MRBtoLT[row - 1][i] = matrix[row - 1][i];
			int j = 1;
			while (j < row && i - j >= 0){
				if (matrix[row - 1 - j][i - j] == 0){
					MRBtoLT[row - 1 - j][i - j] = 0;
				} else {
					MRBtoLT[row - 1 - j][i - j] = MRBtoLT[row - j][i - j + 1] + 1;
				}
				j++;
			}
		}
		for (int i = 0; i < row - 1; i++){
			MRBtoLT[i][col - 1] = matrix[i][col - 1];
			int j = 1;
			while (j < col && i - j >= 0){
				if (matrix[i - j][col - 1 - j] == 0){
					MRBtoLT[i - j][col - 1 - j] = 0;
				} else {
					MRBtoLT[i - j][col - 1 - j] = MRBtoLT[i - j + 1][col - 1 - j + 1] + 1;
				}
				j++;
			}
		}
		
		// Right-Top to Left-Bottom
		int[][] MRTtoLB = new int[row][col];
		for (int i = 0; i < col; i++){
			MRTtoLB[0][i] = matrix[0][i];
			int j = 1;
			while (i - j >= 0 && j < row){
				if (matrix[j][i - j] == 0){
					MRTtoLB[j][i - j] = 0;
				} else {
					MRTtoLB[j][i - j] = MRTtoLB[j - 1][i - j + 1] + 1;
				}
				j++;
			}
		}
		for (int i = 1; i < row; i++){
			MRTtoLB[i][col - 1] = matrix[i][col - 1];
			int j = 1;
			while (i + j < row  && j < col){
				if (matrix[i + j][col - 1 - j] == 0){
					MRTtoLB[i + j][col - 1 - j] = 0;
				} else {
					MRTtoLB[i + j][col - 1 - j] = MRTtoLB[i + j - 1][col - 1 - j + 1] + 1;
				}
				j++;
			}
		}
		
		// Left-Bottom to Right-Top
		int[][] MLBtoRT = new int[row][col];
		for (int i = 0; i < col; i++){
			MLBtoRT[row - 1][i] = matrix[row - 1][i];
			int j = 1;
			while (i + j < col && j < row){
				if (matrix[row - 1 - j][i + j] == 0){
					MLBtoRT[row - 1 - j][i + j] = 0;
				} else {
					MLBtoRT[row - 1 - j][i + j] = MLBtoRT[row - 1 - j + 1][i + j - 1] + 1;
				}
				j++;
			}
		}
		for (int i = 0; i < row - 1; i++){
			MLBtoRT[i][0] = matrix[i][0];
			int j = 1;
			while (i - j >= 0 && j < col){
				if (matrix[i - j][j] == 0){
					MLBtoRT[i - j][j] = 0;
				} else {
					MLBtoRT[i - j][j] = MLBtoRT[i - j + 1][j - 1] + 1;
				}
				j++;
			}
		}
		
		// Conclude to result
		int[][] result = new int[row][col];
		int global = 0;
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				result[i][j] = Math.min(Math.min(Math.min(MLTtoRB[i][j], MRBtoLT[i][j]), 
						MLBtoRT[i][j]), MRTtoLB[i][j]);
				global = Math.max(global, result[i][j]);
			}
		}
		return global;
	}
}
