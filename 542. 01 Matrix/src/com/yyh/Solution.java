package com.yyh;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * 
 * The distance between two adjacent cells is 1.
 */
public class Solution {
	public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> cur = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    cur.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int dis = 0;
        while (!cur.isEmpty()){
            Queue<int[]> next = new LinkedList<>();
            while (!cur.isEmpty()){
                int[] curCell = cur.poll();
                int curRow = curCell[0];
                int curCol = curCell[1];
                res[curRow][curCol] = dis;
                if (curRow > 0 && !visited[curRow - 1][curCol]){
                    visited[curRow - 1][curCol] = true;
                    next.offer(new int[]{curRow - 1, curCol});
                }
                if (curCol > 0 && !visited[curRow][curCol - 1]){
                    visited[curRow][curCol - 1] = true;
                    next.offer(new int[]{curRow, curCol - 1});
                }
                if (curRow < row - 1 && !visited[curRow + 1][curCol]){
                    visited[curRow + 1][curCol] = true;
                    next.offer(new int[]{curRow + 1, curCol});
                }
                if (curCol < col - 1 && !visited[curRow][curCol + 1]){
                    visited[curRow][curCol + 1] = true;
                    next.offer(new int[]{curRow, curCol + 1});
                }
            }
            cur = next;
            dis++;
        }
        return res;
    }
}
