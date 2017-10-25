package com.yyh;
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
public class Solution {
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            n--;
            sb.append((char)(n % 26  + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
