package com.yyh;
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
public class SolutionII {
	public static void main(String[] args){
		SolutionII my = new SolutionII();
		int[][] matrix = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println(my.searchMatrix(matrix, 15));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while(col >= 0 && row <= matrix.length - 1) {
			if(target == matrix[row][col]) {
				return true;
			} else if(target < matrix[row][col]) {
				col--;
			} else if(target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
}
