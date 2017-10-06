package com.yyh;

import java.util.HashMap;

// Given an array of 2D coordinates of points (all the coordinates are integers), 
// find the largest number of points that can be crossed by a single line in 2D space.

class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class MostPointOnLine {
	public int most(Point[] points) {
		int result = 0;
		for (int i = 0; i < points.length; i++){
			Point seed = points[i];
			int same = 1;
			int sameX = 0;
			int most = 0;
			HashMap<Double, Integer> cnt = new HashMap<Double, Integer>();
			for (int j = 0; j < points.length; j++){
				if (i == j){
					continue;
				}
				Point tmp = points[j];
				if (tmp.x == seed.x && tmp.y == seed.y){
					same++;
				} else if (tmp.x == seed.x){
					sameX++;
				} else {
					double slope = ((tmp.y - seed.y) + 0.0) / (tmp.x - seed.x);
					if (!cnt.containsKey(slope)){
						cnt.put(slope, 1);
					} else {
						cnt.put(slope, cnt.get(slope) + 1);
					}
					most = Math.max(most, cnt.get(slope));
				}
			}
			most = Math.max(most, sameX) + same;
			result = Math.max(result, most);
		}
		return result;
	}
}
