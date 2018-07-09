package com.yyh;

public class Solution {
	public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) return false;
        char[] store = new char[26];
        boolean repeat = false;
        int a = -1, b = -1;
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) != B.charAt(i)){
                if (a < 0){
                    a = i;
                } else if (b < 0){
                    b = i;
                } else return false;
            }
            if (++store[A.charAt(i) - 'a'] > 1) repeat = true;
        }
        if (a < 0 && repeat) return true;
        else if (b < 0) return false;
        else return (A.charAt(a) == B.charAt(b)) && (A.charAt(b) == B.charAt(a));
    }
}
