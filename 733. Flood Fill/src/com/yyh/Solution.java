package com.yyh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
 */
public class Solution {
	class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        int color = image[sr][sc];
        boolean[][] vis = new boolean[row][col];
        while (!q.isEmpty()){
            Pair cur = q.poll();
            int x = cur.x, y = cur.y;
            vis[x][y] = true;
            image[x][y] = newColor;
            for (Pair nei : getNei(cur, row, col)){
                if (!vis[nei.x][nei.y] && image[nei.x][nei.y] == color){
                    q.offer(nei);
                }
            }
        }
        return image;
    }
    
    private List<Pair> getNei(Pair p, int row, int col){
        List<Pair> res = new ArrayList<>();
        int x = p.x, y = p.y;
        if (x > 0) res.add(new Pair(x - 1, y));
        if (y > 0) res.add(new Pair(x, y - 1));
        if (x < row - 1) res.add(new Pair(x + 1, y));
        if (y < col - 1) res.add(new Pair(x, y + 1));
        return res;
    }
}
