package com.yyh;
/*
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.
 */
public class Solution {
	public int maxKilledEnemies(char[][] grid) {
		int row = grid.length;
		if (row == 0){
			return 0;
		}
		int col = grid[0].length;
		if (col ==0){
			return 0;
		}
		int[][] M = new int[row][col];
		for (int i = 0; i < row; i++){
			int count = 0;
			for (int j = 0; j < col; j++){
				if (grid[i][j] == 'W'){
					count = 0;
				} else if (grid[i][j] == 'E'){
					count++;
				} else {
					M[i][j] += count;
				}
			}
		}
		for (int i = 0; i < row; i++){
			int count = 0;
			for (int j = col - 1; j >= 0; j--){
				if (grid[i][j] == 'W'){
					count = 0;
				} else if (grid[i][j] == 'E'){
					count++;
				} else {
					M[i][j] += count;
				}
			}
		}
		for (int j = 0; j < col; j++){
			int count = 0;
			for (int i = 0; i < row; i++){
				if (grid[i][j] == 'W'){
					count = 0;
				} else if (grid[i][j] == 'E'){
					count++;
				} else {
					M[i][j] += count;
				}
			}
		}
		int max = 0;
		for (int j = 0; j < col; j++){
			int count = 0;
			for (int i = row - 1; i >= 0; i--){
				if (grid[i][j] == 'W'){
					count = 0;
				} else if (grid[i][j] == 'E'){
					count++;
				} else {
					M[i][j] += count;
					max = Math.max(max, M[i][j]);
				}
			}
		}
		return max;
	}
}
