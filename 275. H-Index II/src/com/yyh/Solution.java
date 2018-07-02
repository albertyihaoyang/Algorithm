package com.yyh;

public class Solution {
	public int hIndex(int[] citations) {
        int N = citations.length;
        if (N == 0 || citations[N - 1] == 0) return 0;
        for (int i = 1; i < N; i++){
            if (citations[N - i] >= i && citations[N - i - 1] <= i) return i;
        }
        return N;
    }
}
