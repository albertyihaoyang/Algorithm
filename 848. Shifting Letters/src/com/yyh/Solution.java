package com.yyh;

public class Solution {
	public String shiftingLetters(String S, int[] shifts) {
        int len = shifts.length;
        int[] totS = new int[len];
        totS[len - 1] = shifts[len - 1] % 26;
        for (int i = len - 2; i >= 0; i--){
            totS[i] = (totS[i + 1] + shifts[i]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++){
            char ch = S.charAt(i);
            sb.append((char)((ch - 'a' + totS[i]) % 26 + 'a'));
        }
        return sb.toString();
    }
}
