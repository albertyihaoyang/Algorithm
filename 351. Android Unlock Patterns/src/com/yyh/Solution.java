package com.yyh;
/*
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.
 */
public class Solution {
	// cur : the current position
    // rem : the steps remaining
    int DFS(boolean[] vis, int[][] skip, int cur, int rem){
        if (rem < 0){
            return 0;
        }
        if (rem == 0){
            return 1;
        }
        vis[cur] = true;
        int rst = 0;
        for (int i = 1; i <= 9; i++){
            // if vis[i] is not visited and (two numbers are adjacent or skip number is already visited){
            if (!vis[i] && (skip[cur][i] == 0 || vis[skip[cur][i]])){
                rst += DFS(vis, skip, i, rem - 1);
            }
        }
        vis[cur] = false;
        return rst;
    }
    
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        boolean[] vis = new boolean[10];
        int rst = 0;
        for (int i = m; i <= n; i++){
            rst += DFS(vis, skip, 1, i - 1) * 4;
            rst += DFS(vis, skip, 2, i - 1) * 4;
            rst += DFS(vis, skip, 5, i - 1);
        }
        return rst;
    }
}
