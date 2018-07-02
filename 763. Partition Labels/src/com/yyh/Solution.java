package com.yyh;
// A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, 
// and return a list of integers representing the size of these parts.
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];
        
        for (int i = 0; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }
        
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
