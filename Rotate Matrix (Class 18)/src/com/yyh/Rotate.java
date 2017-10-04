package com.yyh;

public class Rotate {

	public static void main(String[] args){
		Rotate sol = new Rotate();
		int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		sol.rotate(matrix);
		System.out.println();
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void rotate(int[][] matrix) {
		if (matrix.length <= 1){
			return;
		}
		helper(matrix, 0);
	}

	private void helper(int[][] matrix, int offset){
		if (offset >= matrix.length / 2){
			return;
		}
		for (int i = 0; i < matrix.length - offset * 2 - 1; i++){
			int tmp = matrix[matrix.length - offset - 1 - i][offset];
			matrix[matrix.length - offset - 1 - i][offset] = matrix[matrix.length - offset - 1][matrix.length - offset - 1 - i];
			matrix[matrix.length - offset - 1][matrix.length - offset - 1 - i] = matrix[offset + i][matrix.length - offset - 1];
			matrix[offset + i][matrix.length - offset - 1] = matrix[offset][offset + i];
			matrix[offset][offset + i] = tmp;
		}
		helper(matrix, offset + 1);
	}
}
