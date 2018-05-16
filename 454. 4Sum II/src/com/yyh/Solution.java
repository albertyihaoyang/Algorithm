package com.yyh;

import java.util.HashMap;
import java.util.Map;

/*
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class Solution {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABmap = new HashMap<>();
        Map<Integer, Integer> CDmap = new HashMap<>();
        for (int i: A){
            for (int j: B){
                int tot = i + j;
                ABmap.put(tot, ABmap.getOrDefault(tot, 0) + 1);
            }
        }
        
        for (int k: C){
            for (int l: D){
                int tot = k + l;
                CDmap.put(tot, CDmap.getOrDefault(tot, 0) + 1);
            }
        }
        
        int res = 0;
        for (Map.Entry<Integer, Integer> en: ABmap.entrySet()){
            int key = en.getKey();
            int val = en.getValue();
            res += val * CDmap.getOrDefault(0 - key, 0);
        }
        
        return res;
    }
}
