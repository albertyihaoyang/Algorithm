package com.yyh;

import java.util.HashMap;
import java.util.Map;
/*
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 */
public class Solution {
	public static void main(String[] args){
		Solution my = new Solution();
		int[][] points = new int[][]{{0,0},{1,0},{2,0}};
		System.out.println(my.numberOfBoomerangs(points));
	}
	
	public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++){
                int dis = getDis(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                int cur = entry.getValue();
                res += cur * (cur - 1);
            }
        }
        return res;
    }
    
    private int getDis(int[] p1, int[] p2){
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
