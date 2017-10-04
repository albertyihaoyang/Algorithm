package com.yyh;

public class Largest {

	public static void main(String[] args) {
		Largest my = new Largest();
		int[][] matrix = new int[][]{{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,1,0},{0,0,1,1,0}};
		System.out.println(my.largest(matrix));
	}
	
	public int largest(int[][] matrix) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
	      return 0;
	    }
	    int row = matrix.length;
	    int col = matrix[0].length;
	    int[][] MTB = new int[row][col];
	    int[][] MBT = new int[row][col];
	    int[][] MLR = new int[row][col];
	    int[][] MRL = new int[row][col];
	    int[][] result = new int[row][col];
	    for (int i = 0; i < col; i++){
	      MTB[0][i] = matrix[0][i];
	      for (int j = 1; j < row; j++){
	        if (matrix[j][i] == 0){
	          MTB[j][i] = 0;
	        } else {
	          MTB[j][i] = MTB[j - 1][i] + 1;
	        }
	      }
	    }
	    for (int i = 0; i < col; i++){
	      MBT[row - 1][i] = matrix[row - 1][i];
	      for (int j = row - 2; j >= 0; j--){
	        if (matrix[j][i] == 0){
	          MBT[j][i] = 0;
	        } else {
	          MBT[j][i] = MTB[j + 1][i] + 1;
	        }
	      }
	    }
	    for (int i = 0; i < row; i++){
	      MLR[i][0] = matrix[i][0];
	      for (int j = 1; j < col; j++){
	        if (matrix[i][j] == 0){
	          MLR[i][j] = 0;
	        } else {
	          MLR[i][j] = MLR[i][j - 1] + 1;
	        }
	      }
	    }
	    for (int i = 0; i < row; i++){
	      MRL[i][col - 1] = matrix[i][col - 1];
	      for (int j = col - 2; j >= 0; j--){
	        if (matrix[i][j] == 0){
	          MRL[i][j] = 0;
	        } else {
	          MRL[i][j] = MRL[i][j + 1] + 1;
	        }
	      }
	    }
	    int globalMax = 0;
	    for (int i = 0; i < row; i++){
	      for (int j = 0; j < col; j++){
	        result[i][j] = Math.min(Math.min(Math.min(MTB[i][j], MBT[i][j]), MLR[i][j]), MRL[i][j]);
	        globalMax = Math.max(globalMax, result[i][j]);
	      }
	    }
	    return globalMax;
	  }

}
