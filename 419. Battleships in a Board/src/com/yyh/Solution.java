package com.yyh;

public class Solution {
	public int countBattleships(char[][] board) {
        int res = 0;
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (board[i][j] == '.' || visited[i][j]){
                    visited[i][j] = true;
                } else {
                    int row = i;
                    while (row < rows && board[row][j] == 'x'){
                        visited[row++][j] = true;
                    }
                    int col = j;
                    while (col < cols && board[i][col] == 'x'){
                        visited[i][col++] = true;
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
