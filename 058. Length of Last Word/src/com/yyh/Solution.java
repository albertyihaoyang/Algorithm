package com.yyh;
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
// If the last word does not exist, return 0.
public class Solution {
	public int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < s.length()){
            if (s.charAt(fast++) == ' '){
                slow = fast;
            }
        }
        return fast - slow;
    }
}
