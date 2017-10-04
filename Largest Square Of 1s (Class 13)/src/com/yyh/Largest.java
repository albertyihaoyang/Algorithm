package com.yyh;
// Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), 
// return the length of the largest square.
public class Largest {
	public static void main(String[] args){
		Largest my = new Largest();
		int[][] matrix = new int[][] {{0, 0, 0, 0},{1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		System.out.println(my.largest(matrix));
	}
	public int largest(int[][] matrix) {
	    if (matrix.length == 0){
	    	return 0;
	    } else if (matrix.length == 1){
	    	return matrix[0][0];
	    }
	    int[][] result = new int[matrix.length][matrix.length];
		int max = 0;
	    for (int i = 0; i < matrix.length; i++){
	    	result[0][i] = matrix[0][i];
	    	max = Math.max(max, result[0][i]);
	    	result[i][0] = matrix[i][0];
	    	max = Math.max(max, result[i][0]);
	    }
	    for (int i = 1; i < matrix.length; i++){
	    	for (int j = 1; j < matrix.length; j++){
	    		if (matrix[i][j] == 0){
	    			result[i][j] = 0;
	    		} else {
	    			result[i][j] = 1 + Math.min(Math.min(result[i][j - 1], result[i - 1][j]), 
	    					result[i - 1][j - 1]);
	    			max = Math.max(max, result[i][j]);
	    		}
	    	}
	    }
	    return max;
	 }
}
