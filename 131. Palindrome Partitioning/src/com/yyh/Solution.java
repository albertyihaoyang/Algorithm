package com.yyh;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */

public class Solution {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0){
            return res;
        }
        List<String> cur = new ArrayList<>();
        helper(s, 0, cur, res);
        return res;
    }
    
    public void helper(String s, int ind, List<String> cur, List<List<String>> res){
        if (ind == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = ind; i < s.length() - 1; i++){
            if (is(s, ind, i)){
                cur.add(s.substring(ind, i + 1));
                helper(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
        
        if (is(s, ind, s.length() - 1)){
            cur.add(s.substring(ind));
            helper(s, s.length(), cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public boolean is(String s, int l, int r){
        while (l < r){
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
