package com.yyh;
import java.util.*;
// Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

public class Spiral {
	public static void main(String[] args){
		Spiral my = new Spiral();
		int[][]matrix = {{1, 2, 3}, {4, 5, 6}};
		System.out.println(my.spiral(matrix).toString());
		matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(my.spiral(matrix).toString());
	}
	
	public List<Integer> spiral(int[][] matrix) {
	    List<Integer> result = new ArrayList<Integer>();
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
		      return new ArrayList<Integer>();
		}
	    int rowSize = matrix.length;
	    int colSize = matrix[0].length;
	    spiral(matrix, 0, rowSize, colSize, result);
	    return result;
	  }
	  
	  private void spiral(int[][]matrix, int offset, int rowSize, int colSize, List<Integer> result){
		  if (rowSize == 0 || colSize == 0){
			  return;
		  } else if (rowSize == 1){
			  for (int i = 0; i < colSize; i++){
				  result.add(matrix[offset][offset + i]);
			  }
			  return;
		  }	else if (colSize == 1){
			  for (int i = 0; i < rowSize; i++){
				  result.add(matrix[offset + i][offset]);
			  }
			  return;
		  }
		  for (int i = 0; i < colSize - 1; i++){
			  result.add(matrix[offset][offset + i]);
		  }
		  for (int i = 0; i < rowSize - 1; i++){
			  result.add(matrix[offset + i][matrix[0].length - 1 -offset]);
		  }
		  for (int i = 0; i < colSize - 1; i++){
			  result.add(matrix[matrix.length - 1 - offset][matrix[0].length - 1 - offset - i]);
		  }
		  for (int i = 0; i < rowSize - 1; i++){
			  result.add(matrix[matrix.length - 1 - offset - i][offset]);
		  }
		  spiral(matrix, offset + 1, rowSize - 2, colSize - 2, result);
	  }
}
