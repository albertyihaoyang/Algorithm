package com.yyh;
/*
 * 	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NumIslands {
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public int numIslands(char[][] grid) {
        int res = 0;
		int rows = grid.length;
        if (rows == 0){
        	return res;
        }
        int cols = grid[0].length;
        if (cols == 0){
        	return res;
        }
        boolean[][] map = new boolean[rows + 2][cols + 2];
        for (int i = 0; i < rows; i++){
        	for (int j = 0; j < cols; j++){
        		if (grid[i][j] == '1'){
        			map[i + 1][j + 1] = true;
        		}
        	}
        }
        boolean[][] visited = new boolean[rows + 2][cols + 2];
        for (int i = 1; i < map.length - 1; i++){
        	for (int j = 1; j < map[0].length - 1; j++){
        		if (!map[i][j] || visited[i][j]){
        			continue;
        		}
        		Deque<Pair> deque = new LinkedList<>();
        		deque.offerFirst(new Pair(i, j));
        		while (!deque.isEmpty()){
        			Pair cur = deque.pollFirst();
        			visited[cur.x][cur.y] = true;
        			List<Pair> neis = getNeis(cur);
        			for (Pair nei: neis){
        				if (!visited[nei.x][nei.y] && map[nei.x][nei.y]){
        					deque.offerFirst(nei);
        				}
        			}
        		}
        		res++;
        	}
        }
        return res;
    }
	
	private List<Pair> getNeis(Pair cur){
		List<Pair> neis = new ArrayList<>();
		neis.add(new Pair(cur.x - 1, cur.y));
		neis.add(new Pair(cur.x + 1, cur.y));
		neis.add(new Pair(cur.x, cur.y - 1));
		neis.add(new Pair(cur.x, cur.y + 1));
		return neis;
	}
}
