package com.yyh;

public class Solution {
	public int maxProduct(String[] words) {
        if (words.length < 2) return 0;
        int[][] count = new int[words.length][27];
        int res = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words[i].length(); j++){
                count[i][words[i].charAt(j) - 'a']++;
                count[i][26]++;
            }
        }
        
        for (int i = 1; i < count.length; i++){
            Loop:
            for (int j = 0; j < i; j++){
                for (int k = 0; k < 26; k++){
                    if (count[i][k] > 0 && count[j][k] > 0) continue Loop;
                }
                res = Math.max(res, count[i][26] * count[j][26]);
            }
        }
        return res;
    }
}
