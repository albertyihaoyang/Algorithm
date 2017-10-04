package com.yyh;

public class MatrixReshape {

	public static void main(String[] args) {
		MatrixReshape my = new MatrixReshape();
		int[][] nums = new int[][] {{1, 2}, {3, 4}};
		System.out.println(my.matrixReshape(nums, 1, 4));
	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c){
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < row * col; i++){
            int fromR = i / col;
            int fromC = i % col;
            int toR = i / c;
            int toC = i % c;
            result[toR][toC] = nums[fromR][fromC];
        }
        return result;
    }
}
