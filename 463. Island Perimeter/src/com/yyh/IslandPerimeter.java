package com.yyh;
/*
 * You are given a map in form of a two-dimensional integer grid where 1 represents land 
 * and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or 
 * more connected land cells). The island doesn't have "lakes" (water inside that isn't connected 
 * to the water around the island). One cell is a square with side length 1. The grid is rectangular, 
 * width and height don't exceed 100. Determine the perimeter of the island.
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		IslandPerimeter my = new IslandPerimeter();
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		System.out.println(my.islandPerimeter(grid));

	}

	public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 0 || col == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    count += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1){
                        count--;
                    }
                    if (i + 1 < row && grid[i + 1][j] == 1){
                        count--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1){
                        count--;
                    }
                    if (j + 1 < col && grid[i][j + 1] == 1){
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
