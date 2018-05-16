package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
 * We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 */
public class Solution {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strings.length];
        for (int i = 0; i < strings.length; i++){
            if (visited[i]) continue;
            String s = strings[i];
            List<String> cur = new ArrayList<>();
            cur.add(s);
            for (int j = i + 1; j < strings.length; j++){
                if (visited[j]) continue;
                if (check(s, strings[j])){
                    visited[j] = true;
                    cur.add(strings[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }
    
    private boolean check(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        for (int i = 1; i < s1.length(); i++){
            if ((s1.charAt(i) - s2.charAt(i) + 26) % 26 != (s1.charAt(i - 1) - s2.charAt(i - 1) + 26) % 26){
                return false;
            }
        }
        return true;
    }
}
