package com.yyh;
// Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
public class Solution {
	public boolean validPalindrome(String s) {
        int l = -1;
        int r = s.length();
        while (++l < --r){
            if (s.charAt(l) != s.charAt(r)){
                return is(s, l, r + 1) || is(s, l - 1, r);
            }
        }
        return true;
    }
    
    private boolean is(String s, int l, int r){
        while (++l < -- r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
        }
        return true;
    }
}
