package com.yyh;
/*
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.
 */
public class Solution {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        if (word1.equals(word2)){
            int a = -1;
            for (int i = 0; i < words.length; i++){
                String s = words[i];
                if (s.equals(word1)){
                    res = a == -1? res: Math.min(i - a, res);
                    a = i;
                }
            }
        } else {
            int a = -1;
            int b = -1;
            for (int i = 0; i < words.length; i++){
                String s = words[i];
                if (s.equals(word1)){
                    a = i;
                    res = b == -1? res: Math.min(a - b, res);
                }
                if (s.equals(word2)){
                    b = i;
                    res = a == -1? res: Math.min(b - a, res);
                }
            }
        }
        return res;
    }
}
