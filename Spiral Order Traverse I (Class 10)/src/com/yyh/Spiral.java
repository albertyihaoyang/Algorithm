package com.yyh;
import java.util.*;
// Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

public class Spiral {
	public static void main(String[] args){
		Spiral my = new Spiral();
		int[][]matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println(my.spiral(matrix).toString());
		matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		System.out.println(my.spiral(matrix).toString());
	}
	
	public List<Integer> spiral(int[][] matrix) {
	    List<Integer> result = new ArrayList<Integer>();
	    if (matrix == null){
	      return new ArrayList<Integer>();
	    }
	    spiral(matrix, 0, matrix.length, result);
	    return result;
	  }
	  
	  private void spiral(int[][]matrix, int offset, int size, List<Integer> result){
		  if (size == 0){
			  return;
		  } else if (size == 1){
			  result.add(matrix[offset][offset]);
			  return;
		  }
		  for (int i = 0; i < size - 1; i++){
			  result.add(matrix[offset][offset + i]);
		  }
		  for (int i = 0; i < size - 1; i++){
			  result.add(matrix[offset + i][matrix.length - 1 -offset]);
		  }
		  for (int i = 0; i < size - 1; i++){
			  result.add(matrix[matrix.length - 1 - offset][matrix.length - 1 - offset - i]);
		  }
		  for (int i = 0; i < size - 1; i++){
			  result.add(matrix[matrix.length - 1 - offset - i][offset]);
		  }
		  spiral(matrix, offset + 1, size - 2, result);
	  }
}
