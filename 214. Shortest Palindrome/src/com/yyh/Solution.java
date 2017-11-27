package com.yyh;
/*
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class Solution {
	public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] ch = s.toCharArray();
        while (i < j){
            if (ch[i] == ch[j]){
                i++;
                j--;
            } else {
                i = 0; 
                end--; 
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
