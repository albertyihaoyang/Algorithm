package com.yyh;
// Given three strings A, B and C. Determine if C can be created by merging A and B in 
// a way that maintains the relative order of the characters in A and B.
public class InterleaveStrings {
	public boolean canMerge(String a, String b, String c) {
		int alen = a.length();
		int blen = b.length();
		int clen = c.length();
		if (alen + blen != clen){
			return false;
		}
		boolean[][] canMerge = new boolean[alen + 1][blen + 1];
		for (int i = 0; i <= alen; i++){
			for (int j = 0; j <= blen; j++){
				if (i == 0 && j == 0){
					canMerge[i][j] = true;
				}
				if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1)){
					canMerge[i][j] |= canMerge[i - 1][j];
				}
				if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1)){
					canMerge[i][j] |= canMerge[i][j - 1];
				}
			}
		}
		return canMerge[alen][blen];
	}
}
