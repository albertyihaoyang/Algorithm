package com.yyh;
// Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, 
// using the numbers of 1, 2, 3, …, M * N in increasing order.
public class SpiralGenerate {
	public static void main(String[] args){
		SpiralGenerate my = new SpiralGenerate();
		int[][] matrix = my.spiralGenerate(3, 4);
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 4; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] spiralGenerate(int m, int n) {
	    if (m == 0){
	    	return new int[0][];
	    } else if (n == 0){
	    	return new int[m][0];
	    }
	    int[][] matrix = new int[m][n];
	    spiral(matrix, 0, m, n, 1);
	    return matrix;
	  }
	
	private void spiral(int[][]matrix, int offset, int m, int n, int counter){
		  if (m == 0 || n == 0){
			  return;
		  } else if (m == 1){
			  for (int i = 0; i < n; i++){
				  matrix[offset][offset + i] = counter++;
			  }
			  return;
		  }	else if (n == 1){
			  for (int i = 0; i < m; i++){
				  matrix[offset + i][offset] = counter++;
			  }
			  return;
		  }
		  for (int i = 0; i < n - 1; i++){
			  matrix[offset][offset + i] = counter++;
		  }
		  for (int i = 0; i < m - 1; i++){
			  matrix[offset + i][matrix[0].length - 1 -offset] = counter++;
		  }
		  for (int i = 0; i < n - 1; i++){
			  matrix[matrix.length - 1 - offset][matrix[0].length - 1 - offset - i] = counter++;
		  }
		  for (int i = 0; i < m - 1; i++){
			  matrix[matrix.length - 1 - offset - i][offset] = counter++;
		  }
		  spiral(matrix, offset + 1, m - 2, n - 2, counter);
	  }
}
