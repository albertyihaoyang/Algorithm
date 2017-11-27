package com.yyh;
// Implement wildcard pattern matching with support for '?' and '*'.
public class Solution {
	public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        // advancing both pointers
        while (s < str.length()){
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*'){ // * found, only advancing pattern pointer
                starIdx = p;
                match = s;
                p++;
            } else if (starIdx != -1){ // last pattern pointer was *, advacncing string pointer
                p = starIdx + 1;
                match++;
                s = match;
            } else { // current pattern pointer is not star, last pattern pointer was not * characters do not match
                return false;
            }
        }
        // check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*'){
            p++;
        }
        return p == pattern.length();
    }
}
