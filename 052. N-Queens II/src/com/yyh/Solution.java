package com.yyh;
// Follow up for N-Queens problem.

import java.util.ArrayList;
import java.util.List;

// Now, instead outputting board configurations, return the total number of distinct solutions.
public class Solution {
	int res;
    public int totalNQueens(int n) {
        res = 0;
        if (n <= 0) {
            return res;
        }
        int[] cur = new int[n];
        helper(cur, 0);
        return res;
    }
    
    private void helper(int[] cur, int lvl){
        if (lvl == cur.length) {
            res++;
            return;
        }
        for (int i = 1; i <= cur.length; i++){
            cur[lvl] = i;
            if (valid(cur, lvl)){
                helper(cur, lvl + 1);
            }
        }
    }
    
    boolean valid(int[] cur, int lvl){
        int curL = cur[lvl];
        for (int i = 0; i < lvl; i++){
            if (cur[i] == curL) return false;
            if (Math.abs(cur[i] - curL) == lvl - i) return false;
        }
        return true;
    }
    
    private List<String> gen(int[] stat){
        List<String> cur = new ArrayList<>();
        for (int i : stat){
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < i; j++) sb.append('.');
            sb.append('Q');
            for (int j = i + 1; j <= stat.length; j++) sb.append('.');
            cur.add(sb.toString());
        }
        return cur;
    }
}
