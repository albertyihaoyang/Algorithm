package com.yyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?
 */
public class Solution {
	public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        Map<Integer, Integer> dif = new HashMap<>();
        for (int i = 0; i < n * n; i++){
            if (A[i / n][i % n] == 1){
                LA.add(i / n * 100 + i % n);
            }
        }
        for (int i = 0; i < n * n; i++){
            if (B[i / n][i % n] == 1){
                LB.add(i / n * 100 + i % n);
            }
        }
        for (int i: LA){
            for (int j: LB){
                dif.put(i - j, dif.getOrDefault(i - j, 0) + 1);
            }
        }
        int res = 0;
        for (int i: dif.values()){
            res = Math.max(res, i);
        }
        return res;
    }
}
