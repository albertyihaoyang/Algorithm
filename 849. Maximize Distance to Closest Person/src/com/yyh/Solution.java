package com.yyh;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		int[] test = new int[]{1, 0, 0, 0, 1, 0, 1};
		System.out.print(maxDistToClosest(test));
		
	}
	
	public static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] lToR = new int[len];
        int[] rToL = new int[len];
        lToR[0] = seats[0] == 0 ? len: 0;
        for (int i = 1; i < len; i++){
            if (seats[i] == 0) lToR[i] = lToR[i - 1] + 1;
        }
        rToL[len - 1] = seats[len - 1] == 0 ? len: 0;
        for (int i = len - 2; i >= 0; i--){
            if (seats[i] == 0) rToL[i] = rToL[i + 1] + 1;
        }
        int sol = 0;
        for (int i = 0; i < len; i++){
            sol = Math.max(sol, Math.min(rToL[i], lToR[i]));
        }

        return sol;
    }
}
