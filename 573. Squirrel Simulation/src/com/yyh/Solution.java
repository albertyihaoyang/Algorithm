package com.yyh;

public class Solution {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int num = nuts.length;
        int[] tToN = new int[num];
        int res = 0;
        for (int i = 0; i < num; i++){
            tToN[i] = Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
            res += tToN[i] * 2;
        }
        int[] sToN = new int[num];
        for (int i = 0; i < num; i++){
            sToN[i] = Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++){
            min = Math.min(min, sToN[i] - tToN[i]);
        }
        return res + min;
    }
}
