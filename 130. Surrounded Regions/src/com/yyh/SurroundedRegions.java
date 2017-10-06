package com.yyh;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public void solve(char[][] board) {
		int rows = board.length;
		if (rows == 0){
			return;
		}
		int cols = board[0].length;
		if (rows < 3 || cols < 3){
			return;
		}
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				if (!visited[i][j] && board[i][j] == 'O'){
					Deque<Pair> now = new LinkedList<>();
					Deque<Pair> store = new LinkedList<>();
					boolean isB = false;
					now.offerFirst(new Pair(i, j));
					while (!now.isEmpty()){
						Pair cur = now.pollFirst();
						store.offerFirst(cur);
						visited[cur.x][cur.y] = true;
						List<Pair> neis = getNeis(cur, board);
						if (neis.size() < 4){
							isB = true;
						}
						for (Pair nei: neis){
							if (!visited[nei.x][nei.y] && board[nei.x][nei.y] == 'O'){
								now.offerFirst(nei);
							}
						}
					}
					if (!isB){
						while (!store.isEmpty()){
							Pair cur = store.pollFirst();
							board[cur.x][cur.y] = 'X';
						}
					}
				}
				visited[i][j] = true;
			}
		}
	}
	
	private List<Pair> getNeis (Pair cur, char[][] board){
		List<Pair> neis = new ArrayList<>();
		int rows = board.length;
		int cols = board[0].length;
		if (cur.x + 1 < rows){
			neis.add(new Pair(cur.x + 1, cur.y));
		}
		if (cur.x - 1 >= 0){
			neis.add(new Pair(cur.x - 1, cur.y));
		}
		if (cur.y + 1 < cols){
			neis.add(new Pair(cur.x, cur.y + 1));
		}
		if (cur.y - 1 >= 0){
			neis.add(new Pair(cur.x, cur.y - 1));
		}
		return neis;
	}
}
