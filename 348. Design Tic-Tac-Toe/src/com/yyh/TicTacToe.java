package com.yyh;
/*
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 */
public class TicTacToe {
	int dim;
    int[][] board;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.dim = n;
        this.board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        boolean win = false;
        if (row == col){
            win = true;
            for (int i = 0; i < dim; i++){
                if (board[i][i] != player) win = false;
            }
            if (win) return player;
        }
        if (row + col == dim - 1){
            win = true;
            for (int i = 0; i < dim; i++){
                if (board[i][dim - i - 1] != player) win = false;
            }
            if (win) return player;
        }
        win = true;
        for (int i = 0; i < dim; i++){
            if (board[row][i] != player) win = false;
        }
        if (win) return player;
        win = true;
        for (int i = 0; i < dim; i++){
            if (board[i][col] != player) win = false;
        }
        if (win) return player;
        return 0;
    }
}
